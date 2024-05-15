package com.portfolio.be.entity.user

import com.portfolio.be.entity.common.CommonEntity
import com.portfolio.be.entity.company.Company
import jakarta.persistence.*

@Entity
@Table(name = "`users`")
class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    @Column
    val email:String,
    @Column
    val password:String,

    @OneToMany(mappedBy = "users")
    val companyList:List<Company> = arrayListOf()
):CommonEntity()
