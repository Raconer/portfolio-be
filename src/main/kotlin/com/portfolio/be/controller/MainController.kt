package com.portfolio.be.controller

import com.portfolio.be.service.MainService
import com.portfolio.be.entity.Main
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(
    private val mainService: MainService
) {

    @GetMapping
    fun get():List<Main>{
        return this.mainService.find()
    }
    @PostMapping
    fun post():String{
        this.mainService.save()
        return "SUCCESS"
    }
}