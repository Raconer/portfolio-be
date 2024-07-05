package com.portfolio.be.feature.user.repository.impl

import com.portfolio.be.entity.user.QUsers
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UsersRepositoryImpl (
    private val jpaQueryFactory: JPAQueryFactory
) {
    fun findSignIn(email:String) : SignInDTO.InfoDTO? {
        val users = QUsers.users

        return this.jpaQueryFactory
            .select(
                Projections.fields(
                    SignInDTO.InfoDTO::class.java,
                    users.email.`as`("email"),
                    users.password.`as`("password")
                )
            )
            .from(users)
            .where(
                users.email.eq(email)
            ).fetchFirst()
    }
}