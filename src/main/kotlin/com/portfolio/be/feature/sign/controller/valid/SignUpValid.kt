package com.portfolio.be.feature.sign.controller.valid

import com.portfolio.be.feature.sign.dto.SignUpDTO
import com.portfolio.be.feature.user.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class SignUpValid (
    private val userRepository: UserRepository
): Validator{

    private val logger = LoggerFactory.getLogger(SignUpValid::class.java)

    private lateinit var signUpDTO:SignUpDTO

    override fun supports(clazz: Class<*>): Boolean {
        return SignUpDTO::class.java.isAssignableFrom(clazz)
    }

    override fun validate(target: Any, errors: Errors) {
        signUpDTO = target as SignUpDTO

        // 중복 이메일 체크
        signUpDTO.email.let{ email ->
            if(email.isEmpty()){
                errors.rejectValue("email", "email.empty", "Email is Not Empty")
            }else if (this.userRepository.countByEmail(email) > 0) {
                errors.rejectValue("email", "email.duplicate", "Email is already in use");
            }
        }

    }
}