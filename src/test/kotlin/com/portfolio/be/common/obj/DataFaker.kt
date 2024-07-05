package com.portfolio.be.common.obj

import net.datafaker.Faker

object DataFaker {
    val faker:Faker = Faker()

    fun randomEmail(): String {
        return this.faker.internet().emailAddress()
    }

    fun randomUsername(): String{
        return this.faker.name().username()
    }
}