package com.portfolio.be.common

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestControllerAdvice {

    private val logger = LoggerFactory.getLogger(RestControllerAdvice::class.java)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String?>> {
        val errors: MutableMap<String, String?> = HashMap()
        /*
        ex.bindingResult.allErrors
            .forEach(Consumer { c: ObjectError ->
                errors[(c as FieldError).field] = c.getDefaultMessage()
        })
        */
        return ResponseEntity.badRequest().body(errors)
    }
}