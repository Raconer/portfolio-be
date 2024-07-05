package com.portfolio.be.feature.user.service

import com.portfolio.be.common.Constants
import com.portfolio.be.feature.sign.dto.SignDTO
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.user.repository.impl.UserRepositoryImpl
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepositoryImpl: UserRepositoryImpl
) : UserDetailsService{
    override fun loadUserByUsername(email: String): UserDetails {
        val signInfo:SignInDTO.InfoDTO = this.userRepositoryImpl.findSignIn(email) ?: run {
            throw BadCredentialsException(Constants.SIGN_NOT_FOUNT_USER)
        }

        return SignDTO(signInfo)
    }
}