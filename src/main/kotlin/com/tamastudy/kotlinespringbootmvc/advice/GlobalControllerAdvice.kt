package com.tamastudy.kotlinespringbootmvc.advice

import com.tamastudy.kotlinespringbootmvc.controller.exception.ExceptionApiController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.IndexOutOfBoundsException
import java.lang.RuntimeException

//@ControllerAdvice -> 일반 Controller 용
//@RestControllerAdvice(basePackageClasses = [ExceptionApiController::class])
@RestControllerAdvice
class GlobalControllerAdvice {
    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(e: RuntimeException): String {
        return "Server Error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}