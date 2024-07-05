package com.portfolio.be.feature.user.constroller

import com.portfolio.be.feature.sign.dto.SignDTO
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/user")
class UserController {

    @GetMapping()
    fun getUserInfo(
        @AuthenticationPrincipal
        signDTO: SignDTO
    ): ResponseEntity<Any> {

        println(signDTO.username)

        return ResponseEntity.ok(signDTO)
    }


}