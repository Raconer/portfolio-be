package com.portfolio.be.entity.portfolio

import com.portfolio.be.entity.common.CommonEntity
import com.portfolio.be.entity.job.JobSkill
import jakarta.persistence.*

@Entity
@Table(name = "portfolio_job_skill")
class PortfolioJobSkill(
    @EmbeddedId
    var id: PortfolioJobSkillId,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("portfolioId")
    var portfolio: Portfolio,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("jobSkillId")
    var jobSkill: JobSkill,
):CommonEntity()
