package com.portfolio.be.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table
data class Main(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,
    @Column(nullable = false)
    var name: String? = null,
    @Column(nullable = false)
    var createAt: LocalDateTime? = null,
)
