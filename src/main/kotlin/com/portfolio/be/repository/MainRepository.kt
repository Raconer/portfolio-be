package com.portfolio.be.repository

import com.portfolio.be.entity.Main
import org.springframework.data.jpa.repository.JpaRepository

interface MainRepository: JpaRepository<Main, Long> {
}