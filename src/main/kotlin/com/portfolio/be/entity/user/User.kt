package com.portfolio.be.entity.user

import com.portfolio.be.entity.common.CommonEntity
import com.portfolio.be.entity.company.Company
import com.portfolio.be.feature.sign.dto.SignUpDTO
import jakarta.persistence.*

@Entity
@Table(name = "`user`")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    @Column
    val email:String,
    @Column
    val password:String,

    @OneToMany(mappedBy = "user")
    val companyList:List<Company> = arrayListOf()
):CommonEntity() {
    constructor(signUp:SignUpDTO):this(email = signUp.email,
                                       password = signUp.password)
}
