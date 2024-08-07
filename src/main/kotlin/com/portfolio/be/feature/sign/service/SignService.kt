package com.portfolio.be.feature.sign.service

import com.portfolio.be.feature.sign.dto.RefreshDTO
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.sign.dto.SignUpDTO

interface SignService {
    // CREATE
    fun signUp(signUpDTO: SignUpDTO) : SignUpDTO.ResponseDTO

    // READ
    fun signIn(signInDTO:SignInDTO) : SignInDTO.ResponseDTO
    fun refresh(refreshDTO: RefreshDTO) : SignInDTO.ResponseDTO
}