package com.portfolio.be.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(
) {

    @GetMapping
    fun get():String{
        return "SUCCESS"
    }
    @PostMapping
    fun post():String{
        return "SUCCESS"
    }
}