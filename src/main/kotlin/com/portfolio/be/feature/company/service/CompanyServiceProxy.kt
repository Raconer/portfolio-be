package com.portfolio.be.feature.company.service

import com.portfolio.be.entity.company.Company
import com.portfolio.be.feature.company.dto.CreateDTO
import com.portfolio.be.feature.company.repository.CompanyRepository
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Primary
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Primary
@Service
class CompanyServiceProxy(
    private val companyRepository: CompanyRepository
) : CompanyService{

    private val logger = LoggerFactory.getLogger(CompanyServiceProxy::class.java)

    override fun create(createDTO: CreateDTO): Boolean {

        // FIND USER
        SecurityContextHolder.getContext().authentication


        return true
    }

    override fun get(companyId: Int): Company {
        TODO("Not yet implemented")
    }

    override fun list(companyId: Int): List<Company> {
        TODO("Not yet implemented")
    }

    override fun update(company: Company): Company {
        TODO("Not yet implemented")
    }

    override fun delete(companyId: Int) {
        TODO("Not yet implemented")
    }
}