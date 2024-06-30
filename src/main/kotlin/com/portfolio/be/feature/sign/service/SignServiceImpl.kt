package com.portfolio.be.feature.sign.service

import com.portfolio.be.entity.user.Users
import com.portfolio.be.feature.sign.dto.SignUpDTO
import com.portfolio.be.feature.user.repository.UsersRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SignServiceImpl(
    private val usersRepository: UsersRepository
) : SignService {
    private val logger = LoggerFactory.getLogger(SignServiceImpl::class.java)
    override fun signUp(signUpDTO: SignUpDTO): Boolean {
        logger.info(":::: Start SignUp In SignServiceImpl:::: ")

        val users = Users(signUpDTO)
        this.usersRepository.save(users)

        return true
    }

    override fun signIn(username: String, password: String) : Boolean {
        return true
    }
}