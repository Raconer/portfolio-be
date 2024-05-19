package com.portfolio.be.entity.job

import com.portfolio.be.entity.common.CommonEntity
import jakarta.persistence.*

@Entity
@Table
class JobSkill(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    val job:Job,
    @Column
    val name:String
):CommonEntity()
