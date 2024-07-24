package com.portfolio.be.feature.company.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDate

@Schema(name = "경력 Create DTO", )
data class CreateDTO(
    @field:Schema(description = "회사 이름", required = true)
    @field:NotEmpty
    var name:String,
    @field:Schema(description = "회사 로고(변경 예정 파일로)")
    var logoPath:String? = null,
    @field:Schema(description = "입사일", required = true)
    @field:NotEmpty
    val hireDate: LocalDate,
    @field:Schema(description = "퇴사일")
    val quitDate:LocalDate? = null
)