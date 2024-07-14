package com.portfolio.be.feature.company.service

import com.portfolio.be.entity.company.Company
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Primary
@Service
class CompanyServiceProxy() : CompanyService{
}