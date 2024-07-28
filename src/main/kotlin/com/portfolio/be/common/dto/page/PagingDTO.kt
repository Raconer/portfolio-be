package com.portfolio.be.common.dto.page

import jakarta.validation.constraints.NotNull
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

class PagingDTO {
    @field:NotNull
    val page:Int? = null
    val size:Int = 10

    fun getPageable(page:Int, size:Int):Pageable{
        return PageRequest.of(page, size)
    }

}