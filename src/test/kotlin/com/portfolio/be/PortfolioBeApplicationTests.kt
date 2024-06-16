package com.portfolio.be

import com.portfolio.be.common.obj.DataFaker
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ActiveProfiles("test")
abstract  class PortfolioBeApplicationTests {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(PortfolioBeApplicationTests::class.java.getName())

        @JvmStatic
        @BeforeAll
        fun beforeAll() {
            this.logger.info("Set Before All")
        }
    }

}
