package com.portfolio.be.feature.company.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

@Schema(name = "경력 Create DTO", )
data class CreateDTO(
    @field:Schema(description = "회사 이름", required = true)
    @field:NotEmpty
    var name:String,
    // TODO : 회사 로고 이미지 입력 변경
    var name:String? = null,
    @field:Schema(description = "회사 로고(변경 예정 파일로)")
    var logoPath:String? = null,
    @field:Schema(description = "입사일", required = true)
    @field:NotNull
    val hireDate: LocalDate,
    @field:NotNull
    val hireDate: LocalDate? = null,
    @field:Schema(description = "퇴사일")
    val quitDate:LocalDate? = null
)