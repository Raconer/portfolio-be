package com.portfolio.be.feature.sign.controller

import com.portfolio.be.common.dto.DefResponse
import com.portfolio.be.feature.sign.controller.valid.SignUpValid
import com.portfolio.be.feature.sign.dto.SignInDTO
import com.portfolio.be.feature.sign.dto.SignUpDTO
import com.portfolio.be.feature.sign.service.SignService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign")
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
            return DefResponse.valid(result.allErrors)
        }

        return DefResponse.ok(this.signService.signUp(signUpDTO))
    }

    // READ
    @PostMapping("/in")
    fun signIn(
        @RequestBody
        @Valid
        signIn: SignInDTO
    ) : SignInDTO.ResponseDTO {
        logger.info(":::: Start SignIn :::: ")
        return this.signService.signIn(signIn)
    }
}