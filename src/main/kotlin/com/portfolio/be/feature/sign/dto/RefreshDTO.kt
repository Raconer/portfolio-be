package com.portfolio.be.feature.sign.dto

import kotlinx.serialization.Serializable

@Serializable
data class RefreshDTO(
    val refreshToken: String
){
}