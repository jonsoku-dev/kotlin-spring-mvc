package com.tamastudy.kotlinespringbootmvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class ErrorResponse(
        @field:JsonProperty("result_code")
        var resultCode: String? = null,

        @field:JsonProperty("http_status")
        var httpStatus: String? = null,

        @field:JsonProperty("http_method")
        var httpMethod: String? = null,

        var message: String? = null,
        var path: String? = null,
        var timestamp: LocalDateTime? = null,
        var errors: MutableList<Error>? = mutableListOf()
)

data class Error(
        var field: String? = null,
        var message: String? = null,
        var value: Any? = null
)