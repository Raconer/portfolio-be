package com.portfolio.be.entity.portfolio

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class PortfolioJobSkillId(
    @Column(name = "portfolio_id")
    var portfolioId: Long,
    @Column(name = "job_skill_id")
    var jobSkillId: Long
):Serializable