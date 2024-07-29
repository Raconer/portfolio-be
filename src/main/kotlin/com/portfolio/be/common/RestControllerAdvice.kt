package com.portfolio.be.common

import com.fasterxml.jackson.core.JsonParseException
import com.portfolio.be.common.dto.response.DefResponse
import com.portfolio.be.common.dto.response.ValidDTO
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
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<Any> {
        logger.info("MethodArgumentNotValidException exception: {}", ex.message)

        val errors = arrayListOf<ValidDTO>()
        ex.bindingResult.fieldErrors.forEach {
            errors.add(ValidDTO(it.field, it.defaultMessage))
        }

        return DefResponse.valid(errors)
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