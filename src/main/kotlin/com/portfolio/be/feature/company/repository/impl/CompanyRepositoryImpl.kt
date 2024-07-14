package com.portfolio.be.feature.company.repository.impl

import com.portfolio.be.entity.company.Company
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CompanyRepositoryImpl (
    private val queryFactory: JPAQueryFactory
){

    fun findById(id: Int) : Company?{


        return null
    }

}