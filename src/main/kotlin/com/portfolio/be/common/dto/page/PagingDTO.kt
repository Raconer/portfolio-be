package com.portfolio.be.common.dto.page

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

class PagingDTO {
    val page:Int = 1
    val size:Int = 10

    fun getPageable(page:Int, size:Int):Pageable{
        return PageRequest.of(page, size)
    }

}