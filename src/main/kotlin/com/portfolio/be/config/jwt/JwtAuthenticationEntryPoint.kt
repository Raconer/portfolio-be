package com.portfolio.be.config.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import com.portfolio.be.common.Constants
import com.portfolio.be.common.dto.response.DefResponse
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class JwtAuthenticationEntryPoint(
    private val objectMapper: ObjectMapper
) : AuthenticationEntryPoint {
    private val logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint::class.java)
    @Throws(IOException::class, ServletException::class)
    override fun commence(request: HttpServletRequest,
                          response: HttpServletResponse,
                          authException: AuthenticationException) {
        this.logger.info("Authen Exception : ${authException.message}")
        response.contentType = "application/json"
        response.status = HttpStatus.UNAUTHORIZED.value()

        val body = DefResponse(HttpStatus.UNAUTHORIZED, Constants.UNAUTHORIZED)
        val bodyStr = this.objectMapper.writeValueAsString(body)

        response.writer.write(bodyStr)

    }
}