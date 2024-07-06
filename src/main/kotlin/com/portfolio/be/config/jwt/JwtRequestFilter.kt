package com.portfolio.be.config.jwt

import com.portfolio.be.common.Constants
import com.portfolio.be.common.utils.JwtUtil
import com.portfolio.be.feature.sign.dto.SignDTO
import io.jsonwebtoken.Claims
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtRequestFilter(
    private val jwtUtil: JwtUtil,
) : OncePerRequestFilter() {

    private val logger = LoggerFactory.getLogger(JwtRequestFilter::class.java)
    private val SUB_LEN = Constants.TOKEN_PREFIX.length
    private val EXCLUDE_URL = arrayListOf("/sign")

    override fun doFilterInternal(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  filterChain: FilterChain) {

        logger.info(":::: Auth By Token ::::")
        val bearerToken = request.getHeader(Constants.AUTHORIZATION)

        if (bearerToken != null && bearerToken.isNotEmpty() && bearerToken.startsWith(Constants.TOKEN_PREFIX)) {
            val token: String = bearerToken.substring(this.SUB_LEN)
            this.jwtUtil.getPayLoad(token)?.let { claims: Claims ->
                val email: String = claims["email"] as String
                val signDTO = SignDTO(email = email)
                val authenticationToken = UsernamePasswordAuthenticationToken(signDTO, null, signDTO.authorities)
                SecurityContextHolder.getContext().authentication = authenticationToken
            }
        }
        filterChain.doFilter(request, response)
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        val uri = request.requestURI
        logger.info(":::: Check JWT Filter : ${uri} ::::")
        return this.EXCLUDE_URL.stream().findFirst().filter { prefix ->
            val result = uri.startsWith(prefix)
            result
        }.isPresent
    }
}