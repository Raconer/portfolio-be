package com.portfolio.be

import org.junit.jupiter.api.BeforeAll
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
abstract  class PortfolioBeApplicationTests {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(PortfolioBeApplicationTests::class.java.getName())

        @JvmStatic
        @BeforeAll
        fun beforeAll() {
            this.logger.info("Set Before All")
            System.setProperty("jasypt.encryptor.password", "test");
        }
    }

}
