package com.portfolio.be.entity.company

import com.portfolio.be.entity.common.CommonEntity
import com.portfolio.be.entity.user.Users
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "company")
class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var users: Users,
    @Column
    val name:String,
    @Column
    val logoPath:String? = null,
    @Column(nullable = false)
    val hireDate:LocalDate,
    @Column(nullable = true)
    var quitDate:LocalDate? = null
):CommonEntity()
