package com.portfolio.be.feature.user.controller

import com.portfolio.be.feature.sign.dto.SignDTO
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(
    name = "사용자",
    description = "사용자 관리 및 정보"
)
@RestController
@RequestMapping("/v1/users")
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