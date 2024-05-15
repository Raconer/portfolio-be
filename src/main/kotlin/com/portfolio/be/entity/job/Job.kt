package com.portfolio.be.entity.job

import com.portfolio.be.entity.common.CommonEntity
import jakarta.persistence.*

@Entity
@Table(name = "job")
class Job(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    @ManyToOne
    @JoinColumn(name = "job_type_id", referencedColumnName = "id")
    var jobType: JobType,
    @Column
    var name:String
):CommonEntity()
