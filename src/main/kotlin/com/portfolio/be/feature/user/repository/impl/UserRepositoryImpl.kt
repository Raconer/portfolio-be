package com.portfolio.be.feature.user.repository.impl

import com.portfolio.be.entity.user.QUser
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl (
    private val jpaQueryFactory: JPAQueryFactory
) {
    fun findSignIn(email:String) : SignInDTO.InfoDTO? {
        val user = QUser.user

        return this.jpaQueryFactory
            .select(
                Projections.fields(
                    SignInDTO.InfoDTO::class.java,
                    user.email.`as`("email"),
                    user.password.`as`("password")
                )
            )
            .from(user)
            .where(
                user.email.eq(email)
            ).fetchFirst()
    }
}