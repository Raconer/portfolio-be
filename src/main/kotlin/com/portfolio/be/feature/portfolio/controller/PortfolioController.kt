package com.portfolio.be.feature.portfolio.controller

import com.portfolio.be.feature.portfolio.service.PortfolioService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(
    name = "포트폴리오",
    description = "포트폴리오 관리"
)
@RestController
@RequestMapping("/v1/portfolio")
class PortfolioController(
    private val portfolioService: PortfolioService
) {
    // CREATE
    @PostMapping
    fun create(){
        TODO("추가")
    }

    // READ
    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int){
        TODO("단건 조회")
    }

    @GetMapping
    fun getList(){
        TODO("다건 조회")
    }

    // UPDATE
    @PatchMapping
    fun update(){
        TODO("수정")
    }

    // DELETE
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: Int){
        TODO("삭제")
    }
}