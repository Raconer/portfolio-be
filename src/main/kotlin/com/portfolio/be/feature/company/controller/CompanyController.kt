package com.portfolio.be.feature.company.controller

import com.portfolio.be.feature.company.service.CompanyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(("/company"))
class CompanyController(
    private val companyService: CompanyService
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