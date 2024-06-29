package com.portfolio.be.feature.sign.dto

import jakarta.validation.constraints.NotEmpty

data class SignUpDTO(
    @field:NotEmpty
    val email:String,
    @field:NotEmpty
    val username:String,
    @field:NotEmpty
    val password: String
)
