package com.portfolio.be.feature.company.controller

import com.portfolio.be.common.dto.page.PagingDTO
import com.portfolio.be.feature.company.service.CompanyService
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto
import org.springframework.web.bind.annotation.*

@Tag(
    name = "경력",
    description = "회사 경력"
)
@RestController
@RequestMapping(("/v1/company"))
class CompanyController(
    private val companyService: CompanyService
) {

    private val logger = LoggerFactory.getLogger(CompanyController::class.java)

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
    fun getList(
        page:PagingDTO
    ){
        logger.info(":::: 다건 조회 ::::")
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