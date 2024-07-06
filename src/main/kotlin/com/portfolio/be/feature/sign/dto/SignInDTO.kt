package com.portfolio.be.feature.sign.dto

import jakarta.validation.constraints.NotEmpty
import kotlinx.serialization.Serializable

@Serializable
data class SignInDTO(
    @field:NotEmpty
    var email:String,
    @field:NotEmpty
    var password:String
){
    data class InfoDTO(
        var email:String? = null,
        var password:String? = null
    )

    @Serializable
    data class ResponseDTO(
        val token : String,
        val refreshToken : String
    )
}
