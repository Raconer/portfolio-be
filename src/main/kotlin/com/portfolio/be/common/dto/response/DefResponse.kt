package com.portfolio.be.common.dto.response

import kotlinx.serialization.Serializable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError

@Serializable
data class DefResponse<T>(
    val code:Int,
    val message:String,
    val data:T? = null
){
    constructor(httpStatus: HttpStatus, data:T?):this(httpStatus.value(), httpStatus.name, data)

    companion object {
        fun <T> ok(data:T): ResponseEntity<Any> {
            return ResponseEntity.ok(DefResponse(HttpStatus.OK, data))
        }

        fun validObjectErrors(errors: List<ObjectError>):ResponseEntity<Any> {
            val errorsList = errors.map {
                ValidDTO(it.objectName, it.defaultMessage)
            }

            return this.valid(errorsList)
        }
        fun valid(errors: List<ValidDTO>): ResponseEntity<Any> {
            val validList = arrayListOf<ValidDTO>()

            errors.forEach{ error ->

                val valid = ValidDTO(error.field, error.message)

                validList.add(valid)
            }

            return ResponseEntity.ok(DefResponse(HttpStatus.BAD_REQUEST, validList))
        }

        fun status(status: HttpStatus, data: Any?): ResponseEntity<Any> {
            return ResponseEntity(DefResponse(status, data), status)
        }
    }
}