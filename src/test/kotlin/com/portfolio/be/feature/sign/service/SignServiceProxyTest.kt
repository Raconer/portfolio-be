package com.portfolio.be.feature.sign.service

import com.portfolio.be.PortfolioBeApplicationTests
import com.portfolio.be.common.obj.DataFaker
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.sign.dto.SignUpDTO
import jakarta.transaction.Transactional
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import javax.xml.datatype.DatatypeFactory

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class) // Order 어노테이션 적용
class SignServiceProxyTest @Autowired constructor(
    private val signService: SignService,
) : PortfolioBeApplicationTests() {

    private val TEMP_EMAIL =  DataFaker.randomEmail()

    @Test
    @Transactional
    @Order(1)
    fun signUp() {
        // GIVEN
        val signUpDTO = SignUpDTO(
            TEMP_EMAIL,
            DataFaker.randomUsername(),
            Constants.PASSWORD
        )
        // WHEN & THEN
        assertTrue(this.signService.signUp(signUpDTO))

    }

    @Test
    @Transactional
    @Order(2)
    fun signIn() {
        // GIVEN
        // 로그인 테스트를 위한 회원가입
        this.signUp()

        val signIn = SignInDTO(
            TEMP_EMAIL,
            Constants.PASSWORD
        )
        // WHEN
        val res = this.signService.signIn(signIn)
        // THEN
        assertNotNull(res.token)
    }
}