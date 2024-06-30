package com.portfolio.be.common.utils

import com.portfolio.be.PortfolioBeApplicationTests
import com.portfolio.be.common.enums.SignTokenEnum
import com.portfolio.be.common.obj.DataFaker
import io.jsonwebtoken.Claims
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class JwtUtilTest @Autowired constructor(
    private val jwtUtil: JwtUtil
) : PortfolioBeApplicationTests(){
    var token: String? = null
    var email: String = DataFaker.randomEmail()

    @Test
    @Order(1)
    fun `Token Create`() {
        // GIVEN
        val payload = mutableMapOf<String, String>()
        payload["email"] = email

        // WHEN
        token = this.jwtUtil.createToken(SignTokenEnum.ACCESS, payload)

        // THEN
        Assertions.assertNotNull(token)
    }

    @Test
    @Order(2)
    fun `Token Validate`(){
        // GIVEN
        // WHEN
        println("token : ${token}")
        val isValidate = this.jwtUtil.validate(token!!)

        // THEN
        Assertions.assertTrue(isValidate)
    }

    @Test
    @Order(3)
    fun `Token Payload Check`(){
        // GIVEN
        // WHEN
        val payload:Claims = this.jwtUtil.getPayLoad(token!!)!!

        // THEN
        Assertions.assertEquals(email, payload["email"])
    }
}