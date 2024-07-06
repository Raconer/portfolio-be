package com.portfolio.be.feature.sign.dto

import kotlinx.serialization.Serializable
@Serializable
data class SignUpDTO(
    val email:String,
    val username:String,
    var password: String
) {
    @Serializable
    data class ResponseDTO(
        val success : Boolean,
    )
}
