package com.portfolio.be.feature.sign.controller

import com.portfolio.be.PortfolioBeApplicationTests
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class) // Order 어노테이션 적용
class SignControllerTest() : PortfolioBeApplicationTests() {

    @Test
    fun `회원 가입 테스트`(){

    }

    @Test
    fun `로그인 테스트`(){

    }
}