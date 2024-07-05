package com.portfolio.be.common.dto

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError

data class DefResponse(
    val code:Int,
    val message:String,
    val data:Any? = null
){
    constructor(httpStatus: HttpStatus, data:Any?):this(httpStatus.value(), httpStatus.name, data)

    companion object {
        fun ok(data:Any?): ResponseEntity<Any> {
            return ResponseEntity.ok(DefResponse(HttpStatus.OK, data))
        }

        fun valid(errors: List<ObjectError>): ResponseEntity<Any> {
            val validList = arrayListOf<ValidDTO>()

            errors.forEach{ error ->
                println(error)
                error as FieldError
                val valid = ValidDTO(error.field, error.defaultMessage)

                validList.add(valid)
            }

            return ResponseEntity.ok(DefResponse(HttpStatus.BAD_REQUEST, validList))
        }

        fun status(status: HttpStatus, data: Any?): ResponseEntity<Any> {
            return ResponseEntity(DefResponse(status, data), status)
        }
    }
}