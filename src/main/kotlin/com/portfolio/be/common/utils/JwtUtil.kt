package com.portfolio.be.common.utils

import com.portfolio.be.common.enums.SignTokenEnum
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtUtil {
    @Value("\${jwt.secret.key}")
    private val SECRET_KEY: String? = null
    @Value("\${jwt.access.expire}")
    private val ACCESS_EXPIRE: Long = 0
    @Value("\${jwt.refresh.expire}")
    private val REFRESH_EXPIRE: Long = 0

    fun createToken(type:SignTokenEnum, payloads: Map<String, String>): String {
        val key = this.getSigningKey()

        val issuedAt = Date()
        val expiration = Date()

        expiration.time +=
            if(type == SignTokenEnum.REFRESH) this.REFRESH_EXPIRE
            else this.ACCESS_EXPIRE

        return Jwts.builder()
            .claims(payloads)
            .issuedAt(issuedAt).expiration(expiration)
            .signWith(key, Jwts.SIG.HS256).compact()
    }

    fun getPayLoad(token: String):Claims?{
        val key = this.getSigningKey()

        return Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .payload
    }

    fun validate(token: String): Boolean {
        return try {
            val payload = this.getPayLoad(token)
            // 토큰이 유효한지 추가 검증 (필요한 경우)
            payload != null
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    private fun getSigningKey(): SecretKey {
        return Keys.hmacShaKeyFor(this.SECRET_KEY!!.toByteArray())
    }
}