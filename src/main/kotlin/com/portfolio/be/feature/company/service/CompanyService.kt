package com.portfolio.be.feature.company.service

import com.portfolio.be.entity.company.Company
import com.portfolio.be.feature.company.dto.CreateDTO

interface CompanyService {
    fun create(createDTO: CreateDTO): Boolean
    fun get(companyId: Int): Company
    fun list(companyId: Int): List<Company>
    fun update(company: Company): Company
    fun delete(companyId: Int)
}