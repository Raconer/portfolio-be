package com.portfolio.be.entity.job

import com.portfolio.be.entity.common.CommonEntity
import jakarta.persistence.*

@Entity
@Table(name = "job_type")
class JobType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    @Column
    val name:String,
):CommonEntity()
