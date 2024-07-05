package com.portfolio.be.feature.sign.controller

import com.portfolio.be.PortfolioBeApplicationTests
import com.portfolio.be.common.Constants
import com.portfolio.be.common.obj.Converter
import com.portfolio.be.common.obj.DataFaker
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.sign.dto.SignUpDTO
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class) // Order 어노테이션 적용
class SignControllerTest @Autowired constructor(
    private val mock: MockMvc,
) : PortfolioBeApplicationTests() {

    private val PATH = "/sign"
    private val EMAIL = DataFaker.randomEmail()

    @Test
    @Order(1)
    @Transactional
    fun `회원 가입 테스트`(){
        // GIVEN
        val signUpDTO = SignUpDTO(
            email = EMAIL,
            DataFaker.randomUsername(),
            password = Constants.PASSWORD
        )
        val jsonStr = Converter.getJsonByObj(signUpDTO)

        // WHEN & THEN
        this.mock.perform(
            MockMvcRequestBuilders.post("$PATH/up")
            .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr)

        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    @Order(2)
    @Transactional
    fun `로그인 테스트`(){
        // GIVEN
        this.`회원 가입 테스트`()

        val signInDTO = SignInDTO(
            email = EMAIL,
            password = Constants.PASSWORD
        )
        val jsonStr = Converter.getJsonByObj(signInDTO)

        // WHEN & THEN
        this.mock.perform(
            MockMvcRequestBuilders.post("$PATH/in")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr)

        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
}