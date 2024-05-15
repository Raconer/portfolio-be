package com.portfolio.be.entity.template

import com.portfolio.be.entity.common.CommonEntity
import jakarta.persistence.*

@Entity
@Table(name = "template")
class Template(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    @Column
    var name:String,
    @Column
    val template:String
):CommonEntity()
