package com.portfolio.be.feature.sign.service

import com.portfolio.be.common.Constants
import com.portfolio.be.common.enums.SignTokenEnum
import com.portfolio.be.common.utils.JwtUtil
import com.portfolio.be.entity.user.User
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.sign.dto.SignUpDTO
import com.portfolio.be.feature.user.repository.UserRepository
import com.portfolio.be.feature.user.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignServiceImpl(
    private val userService: UserService,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
) : SignService {

    private val logger = LoggerFactory.getLogger(SignServiceImpl::class.java)

    override fun signUp(signUpDTO: SignUpDTO): Boolean {
        logger.info(":::: Start SignUp In SignServiceImpl:::: ")

        signUpDTO.password = this.passwordEncoder.encode(signUpDTO.password)

        val user = User(signUpDTO)
        this.userRepository.save(user)

        return true
    }

    override fun signIn(signIn:SignInDTO) : SignInDTO.ResponseDTO {
        val email = signIn.email
        val userInfo = this.userService.loadUserByUsername(email)

        if(passwordEncoder.matches(userInfo.password, signIn.password)){
            throw BadCredentialsException(Constants.SIGN_IN_NOT_MATCH)
        }

        val token = this.jwtUtil.createToken(SignTokenEnum.ACCESS, email)

        return SignInDTO.ResponseDTO(
            token
        )
    }
}