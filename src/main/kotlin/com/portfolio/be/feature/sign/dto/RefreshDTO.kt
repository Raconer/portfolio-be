package com.portfolio.be.feature.sign.dto

import jakarta.validation.constraints.NotEmpty
import kotlinx.serialization.Serializable

@Serializable
data class RefreshDTO(
    @field:NotEmpty
    val refreshToken: String
){

}
