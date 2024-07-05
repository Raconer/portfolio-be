package com.portfolio.be.common.enums

import org.springframework.http.HttpStatus

enum class HttpStatusEnum(
    val code:Int,
    val message:String,
) {
    OK(HttpStatus.OK.value(), HttpStatus.OK.name)
}