package com.portfolio.be.feature.company.controller

import com.portfolio.be.common.dto.page.PagingDTO
import com.portfolio.be.feature.company.dto.CreateDTO
import com.portfolio.be.feature.company.service.CompanyService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto
import org.springframework.http.ResponseEntity
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
    @Operation(summary = "경력 추가", description = "사용자 회사 경력 추가")
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "성공"
        )
    )
    @PostMapping
    fun create(
        @RequestBody
        @Valid
        createDTO: CreateDTO
    ):ResponseEntity<Any>{

        return ResponseEntity.ok(null)
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