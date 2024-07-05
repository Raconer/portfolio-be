package com.portfolio.be.common.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RedisService(
    private val redisTemplate: RedisTemplate<String, Any>
) {
    fun save(key: String, value: Any) {
        redisTemplate.opsForValue().set(key, value)
    }

    fun find(key: String): Any? {
        return redisTemplate.opsForValue().get(key)
    }
}