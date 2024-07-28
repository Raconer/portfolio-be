package com.portfolio.be.common

import com.fasterxml.jackson.core.JsonParseException
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.function.Consumer

@RestControllerAdvice
class RestControllerAdvice {

    private val logger = LoggerFactory.getLogger(RestControllerAdvice::class.java)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String>> {
        logger.info("MethodArgumentNotValidException exception: {}", ex.message)
        val errors = ex.bindingResult.fieldErrors.associate {
            it.field to (it.defaultMessage ?: "Unknown error")
        }
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(JsonParseException::class)
    fun handleJsonParseException(ex: JsonParseException): ResponseEntity<Map<String, String?>> {
        logger.info("JsonParseException exception: {}", ex.message)
        val error = mapOf("error" to ex.message)
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<Map<String, String>> {
        logger.info("HttpMessageNotReadableException exception: {}", ex.message)
        return ResponseEntity(null, HttpStatus.BAD_REQUEST)
    }
}