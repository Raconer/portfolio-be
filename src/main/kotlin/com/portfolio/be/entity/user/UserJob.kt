package com.portfolio.be.entity.user

import com.portfolio.be.entity.common.CommonEntity
import com.portfolio.be.entity.job.Job
import jakarta.persistence.*

@Entity
@Table(name = "user_job")
class UserJob(
    @EmbeddedId
    val userJobId: UserJobId,
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    var user: User,
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("jobId")
    var job: Job
):CommonEntity()
