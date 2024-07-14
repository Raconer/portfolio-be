package com.portfolio.be.feature.sign.controller

import com.portfolio.be.PortfolioBeApplicationTests
import com.portfolio.be.common.Constants
import com.portfolio.be.common.dto.response.DefResponse
import com.portfolio.be.common.obj.DataFaker
import com.portfolio.be.feature.sign.dto.RefreshDTO
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.sign.dto.SignUpDTO
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class) // Order 어노테이션 적용
class SignControllerTest @Autowired constructor(
    private val mock: MockMvc
) : PortfolioBeApplicationTests() {

    private val logger: Logger = LoggerFactory.getLogger(SignControllerTest::class.java.getName())

    private val PATH = "/sign"
    private val EMAIL = DataFaker.randomEmail()
    private var TOKEN: String? = null
    private var REFRESH_TOKEN: String? = null

    @BeforeAll
    @Transactional
    fun setup() {}

    @Test
    @Order(1)
    @Transactional
    fun `회원가입`() {
        // GIVEN
        val signUpDTO = SignUpDTO(
            email = EMAIL,
            username = DataFaker.randomUsername(),
            password = Constants.PASSWORD
        )
        val jsonStr = Json.encodeToString(signUpDTO)

        // WHEN
        val result = this.mock.perform(
            MockMvcRequestBuilders.post("$PATH/up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
            .andReturn()

        val data = Json.decodeFromString<DefResponse<SignUpDTO.ResponseDTO>>(result.response.contentAsString)

        // THEN
        assertTrue( data.data?.success ?:false)
    }

    @Test
    @Order(2)
    @Transactional
    fun `로그인`() {

        // GIVEN
        this.회원가입()

        val signInDTO = SignInDTO(
            email = EMAIL,
            password = Constants.PASSWORD
        )
        val signInJsonStr = Json.encodeToString(signInDTO)
        // WHEN
        val result: MvcResult = this.mock.perform(
            MockMvcRequestBuilders.post("$PATH/in")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signInJsonStr)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
            .andReturn()


        val data =  Json.decodeFromString<DefResponse<SignInDTO.ResponseDTO>>(result.response.contentAsString)
        TOKEN = data.data!!.token
        REFRESH_TOKEN = data.data!!.refreshToken
        logger.info(":::: token : $TOKEN ::::")
        logger.info(":::: refreshToken : $REFRESH_TOKEN ::::")

        // THEN
        assertTrue(TOKEN != null && REFRESH_TOKEN != null)
    }

    @Test
    @Order(3)
    @Transactional
    fun `리프레시`() {
        // GIVEN
        this.로그인()

        println(REFRESH_TOKEN)
        val refreshDTO = RefreshDTO(REFRESH_TOKEN!!)
        val jsonStr = Json.encodeToString(refreshDTO)

        // WHEN & THEN
        this.mock.perform(
            MockMvcRequestBuilders.post("$PATH/refresh")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
}