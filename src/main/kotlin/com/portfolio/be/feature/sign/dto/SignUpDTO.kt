package com.portfolio.be.feature.sign.dto

data class SignUpDTO(
    val email:String,
    val username:String,
    var password: String
)
