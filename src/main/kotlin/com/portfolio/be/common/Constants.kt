package com.portfolio.be.common

object Constants {
    // Auth
    const val AUTHORIZATION = "Authorization"
    const val TOKEN_PREFIX = "Bearer "
    // Sign
    const val REDIS_REFRESH_PREFIX = "refreshToken:"
    // EXCEPTION MESSAGE
    // - AUTH
    const val UNAUTHORIZED = "UNAUTHORIZED"
    // - SIGN
    const val SIGN_NOT_FOUNT_USER = "User not found"
    const val SIGN_IN_NOT_MATCH = "Not Equals Sign In Data"

}