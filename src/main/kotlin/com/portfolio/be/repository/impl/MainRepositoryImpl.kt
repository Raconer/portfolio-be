package com.portfolio.be.repository.impl

import com.portfolio.be.entity.Main
import com.portfolio.be.entity.QMain.main
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class MainRepositoryImpl (
    private val queryFactory: JPAQueryFactory
){

    fun findAll():List<Main>{
        return this.queryFactory.selectFrom(main).fetch()
    }

}