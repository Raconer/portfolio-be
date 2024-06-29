package com.portfolio.be.feature.user.repository

import com.portfolio.be.entity.user.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<Users, Long>{
    fun countByEmail(email: String): Int
}