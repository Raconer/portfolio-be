package com.portfolio.be.feature.sign.controller

import com.portfolio.be.common.dto.response.DefResponse
import com.portfolio.be.feature.sign.controller.valid.SignUpValid
import com.portfolio.be.feature.sign.dto.RefreshDTO
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.sign.dto.SignUpDTO
import com.portfolio.be.feature.sign.service.SignService
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(
    name = "인증",
    description = "로그인 및 토큰 인증"
)
@RestController
@RequestMapping("/v1/sign")
class SignController (
    private val signService: SignService,
    private val signUpValid: SignUpValid
){
    private val logger = LoggerFactory.getLogger(SignController::class.java)

    // CREATE
    @PostMapping("/up")
    fun signUp(
        @RequestBody
        signUpDTO: SignUpDTO,
        result:BindingResult
    ) : ResponseEntity<Any> {
        logger.info(":::: Start SignUp :::: ")
        signUpValid.validate(signUpDTO, result)
        if (result.hasErrors()) {
            return DefResponse.validObjectErrors(result.allErrors)
        }

        return DefResponse.ok(this.signService.signUp(signUpDTO))
    }

    // READ
    @PostMapping("/in")
    fun signIn(
        @RequestBody
        @Valid
        signIn: SignInDTO
    ) : ResponseEntity<Any> {
        logger.info(":::: Start SignIn :::: ")

        return DefResponse.ok(this.signService.signIn(signIn))
    }

    @PostMapping("/refresh")
    fun refresh(
        @RequestBody
        @Valid
        refreshDTO: RefreshDTO
    ): ResponseEntity<Any> {
        logger.info(":::: Start Refresh :::: ")

        return ResponseEntity.ok(this.signService.refresh(refreshDTO))
    }

}