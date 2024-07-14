package com.portfolio.be.feature.company.repository

import com.portfolio.be.entity.company.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository : JpaRepository<Company, Long> {
}