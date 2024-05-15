package com.portfolio.be.entity.portfolio

import com.portfolio.be.entity.common.CommonEntity
import com.portfolio.be.entity.company.Company
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "portfolio")
class Portfolio (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    var company:Company,
    @Column
    val startAt:LocalDate,
    @Column
    var endAt:LocalDate? = null,
    @Column
    var title:String,
    @Column(name = "`name`")
    var desc:String,
    @Column
    var content:String,
    @OneToMany(mappedBy = "portfolio", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var portfolioJobSkills: List<PortfolioJobSkill> = arrayListOf()
):CommonEntity()