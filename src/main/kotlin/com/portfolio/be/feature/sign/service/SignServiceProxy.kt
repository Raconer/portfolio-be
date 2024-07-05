package com.portfolio.be.feature.sign.service

import com.portfolio.be.common.service.RedisService
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
    override fun signUp(signUpDTO: SignUpDTO): Boolean {
        logger.info(":::: Start SignUp In Proxy:::: ")
        logger.info(":::: ${this.redisService.save(signUpDTO.email, "test")} ::::")

        return this.signService.signUp(signUpDTO)
    }
    // READ
    override fun signIn(signInDTO: SignInDTO) : SignInDTO.ResponseDTO {
        logger.info(":::: ${this.redisService.find(signInDTO.email)} ::::")
        return this.signService.signIn(signInDTO)
    }
}