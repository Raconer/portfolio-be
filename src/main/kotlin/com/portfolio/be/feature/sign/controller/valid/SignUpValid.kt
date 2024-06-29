package com.portfolio.be.feature.sign.controller.valid

import com.portfolio.be.feature.sign.dto.SignUpDTO
import com.portfolio.be.feature.user.repository.UsersRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

@Component
class SignUpValid (
    private val usersRepository: UsersRepository
): Validator{

    private val logger = LoggerFactory.getLogger(SignUpValid::class.java)

    private lateinit var signUpDTO:SignUpDTO

    override fun supports(clazz: Class<*>): Boolean {
        return SignUpDTO::class.java.isAssignableFrom(clazz)
    }

    override fun validate(target: Any, errors: Errors) {
        signUpDTO = target as SignUpDTO

        // 중복 이메일 체크
        if (this.usersRepository.countByEmail(signUpDTO.email) > 0) {
            errors.rejectValue("email", "email.duplicate", "Email is already in use");
        }

    }
}