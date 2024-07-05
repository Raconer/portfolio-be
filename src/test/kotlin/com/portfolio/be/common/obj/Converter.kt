package com.portfolio.be.common.obj

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper

object Converter {

    private val objectMapper = ObjectMapper()

    fun getJsonByObj(data: Any?): String {
        var jsonBody = ""
        try {
            jsonBody = this.objectMapper.writeValueAsString(data)
        } catch (e: JsonProcessingException) {
            e.printStackTrace()
        }
        return jsonBody
    }
}