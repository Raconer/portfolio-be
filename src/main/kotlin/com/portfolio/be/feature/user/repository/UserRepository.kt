package com.portfolio.be.feature.user.repository

import com.portfolio.be.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{
    fun countByEmail(email: String): Int
}