package com.portfolio.be.feature.user.service

import com.portfolio.be.common.Constants
import com.portfolio.be.feature.sign.dto.SignDTO
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.user.repository.impl.UsersRepositoryImpl
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsersService(
    private val usersRepositoryImpl: UsersRepositoryImpl
) : UserDetailsService{
    override fun loadUserByUsername(email: String): UserDetails {
        val signInfo:SignInDTO.InfoDTO = this.usersRepositoryImpl.findSignIn(email)?:run {
            throw BadCredentialsException(Constants.SIGN_NOT_FOUNT_USER)
        }

        return SignDTO(signInfo)
    }
}