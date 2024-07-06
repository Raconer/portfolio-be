package com.portfolio.be.feature.sign.service

import com.portfolio.be.common.Constants
import com.portfolio.be.common.service.RedisService
import com.portfolio.be.feature.sign.dto.RefreshDTO
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.sign.dto.SignUpDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
@Primary
class SignServiceProxy (
    @Qualifier("signServiceImpl")
    private val signService: SignService,
    private val redisService: RedisService
) : SignService{
    private val logger = LoggerFactory.getLogger(SignServiceProxy::class.java)

    // CREATE
    override fun signUp(signUpDTO: SignUpDTO): SignUpDTO.ResponseDTO {
        logger.info(":::: Start SignUp In Proxy:::: ")
        return this.signService.signUp(signUpDTO)
    }
    // READ
    override fun signIn(signInDTO: SignInDTO) : SignInDTO.ResponseDTO {
        val signInResDTO = this.signService.signIn(signInDTO)
        this.redisService.save(Constants.REDIS_REFRESH_PREFIX + signInResDTO.refreshToken, signInDTO.email)

        return signInResDTO
    }

    override fun refresh(refreshDTO: RefreshDTO): SignInDTO.ResponseDTO {
        val data = this.redisService.find(Constants.REDIS_REFRESH_PREFIX + refreshDTO.refreshToken)
        println(data)
        return SignInDTO.ResponseDTO(
            "",
            ""
        )
    }
}