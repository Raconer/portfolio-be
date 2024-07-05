package com.portfolio.be.feature.sign.service

import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.sign.dto.SignUpDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Primary
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@Primary
class SignServiceProxy (
    @Qualifier("signServiceImpl")
    private val signService: SignService,
) : SignService{
    private val logger = LoggerFactory.getLogger(SignServiceProxy::class.java)

    // CREATE
    override fun signUp(signUpDTO: SignUpDTO): Boolean {
        logger.info(":::: Start SignUp In Proxy:::: ")


        return this.signService.signUp(signUpDTO)
    }
    // READ
    override fun signIn(signIn: SignInDTO) : SignInDTO.ResponseDTO {
        return this.signService.signIn(signIn)
    }
}