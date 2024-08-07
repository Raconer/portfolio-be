package com.portfolio.be.entity.user

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class UserJobId (
    @Column(name = "user_id")
    val userId:Long,
    @Column(name = "job_id")
    val jobId:Long
):Serializable