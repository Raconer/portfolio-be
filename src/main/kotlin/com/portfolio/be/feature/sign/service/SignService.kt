package com.portfolio.be.feature.sign.service

import com.portfolio.be.feature.sign.dto.SignUpDTO

interface SignService {
    // CREATE
    fun signUp(signUpDTO: SignUpDTO) : Boolean

    // READ
    fun signIn(username: String, password: String) : Boolean
}