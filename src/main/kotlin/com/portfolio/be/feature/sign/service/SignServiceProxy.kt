package com.portfolio.be.feature.sign.service

import com.portfolio.be.common.Constants
import com.portfolio.be.common.utils.JwtUtil
import com.portfolio.be.entity.user.User
import com.portfolio.be.feature.sign.dto.RefreshDTO
import com.portfolio.be.feature.sign.dto.SignDTO
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.sign.dto.SignUpDTO
import com.portfolio.be.feature.user.repository.UserRepository
import com.portfolio.be.feature.user.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Primary
@Service
class SignServiceProxy (
    private val userService: UserService,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val redisTemplate: RedisTemplate<String, Any>,
    private val jwtUtil: JwtUtil
) : SignService{

    private val logger = LoggerFactory.getLogger(SignServiceProxy::class.java)
    @Value("\${jwt.refresh.expire}")
    private val REFRESH_EXPIRE: Long = 0

    // CREATE
    override fun signUp(signUpDTO: SignUpDTO): SignUpDTO.ResponseDTO {
        logger.info(":::: Start SignUp In Proxy:::: ")

        signUpDTO.password = this.passwordEncoder.encode(signUpDTO.password)

        val user = User(signUpDTO)
        this.userRepository.save(user)

        return SignUpDTO.ResponseDTO(
            true
        )
    }
    // READ
    // TODO : 토큰 인증 Redis 구조 확인 필요
    override fun signIn(signInDTO: SignInDTO) : SignInDTO.ResponseDTO {

        val email = signInDTO.email
        val signInfo:SignDTO = this.userService.loadUserByUsername(email)

        if(passwordEncoder.matches(signInfo.password, signInDTO.password)){
            throw BadCredentialsException(Constants.SIGN_IN_NOT_MATCH)
        }

        return this.getSignRes(email)
    }

    override fun refresh(refreshDTO: RefreshDTO): SignInDTO.ResponseDTO {
        val key = Constants.REDIS_REFRESH_PREFIX + refreshDTO.refreshToken

        this.redisTemplate.opsForValue().get(key)?.let { email  ->
            email as String
            this.redisTemplate.delete(key)
            return this.getSignRes(email)
        }

        throw UsernameNotFoundException(Constants.SIGN_NOT_FOUNT_USER)
    }

    private fun getSignRes(email:String):SignInDTO.ResponseDTO{
        if(this.userRepository.countByEmail(email) == 1){
            val (token, refreshToken) = this.jwtUtil.createAuthToken(email)

            this.redisTemplate.opsForValue().set(Constants.REDIS_REFRESH_PREFIX + refreshToken, email, this.REFRESH_EXPIRE, TimeUnit.MILLISECONDS)

            return SignInDTO.ResponseDTO(
                token,
                refreshToken
            )
        }
        throw UsernameNotFoundException(Constants.SIGN_IN_NOT_MATCH)
    }
}