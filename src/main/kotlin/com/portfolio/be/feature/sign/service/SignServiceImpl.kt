package com.portfolio.be.feature.sign.service

import com.portfolio.be.feature.sign.dto.SignUpDTO
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SignServiceImpl(

) : SignService {
    private val logger = LoggerFactory.getLogger(SignServiceImpl::class.java)
    override fun signUp(signUpDTO: SignUpDTO): Boolean {
        logger.info(":::: Start SignUp In SignServiceImpl:::: ")
        return true
    }

    override fun signIn(username: String, password: String) : Boolean {
        return true
    }
}