package com.portfolio.be.feature.sign.service

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
    private val passwordEncoder: PasswordEncoder
) : SignService{
    private val logger = LoggerFactory.getLogger(SignServiceProxy::class.java)

    // CREATE
    override fun signUp(signUp: SignUpDTO): Boolean {
        logger.info(":::: Start SignUp In Proxy:::: ")

        signUp.password = this.passwordEncoder.encode(signUp.password)

        return this.signService.signUp(signUp)
    }
    // READ
    override fun signIn(username: String, password: String) : Boolean {
        return this.signService.signIn(username, password)
    }
}