package com.tamastudy.kotlinespringbootmvc.controller.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.IndexOutOfBoundsException
import java.lang.RuntimeException

/**
 * 실제로 이런 api 는 존재하지 않음. 연습용
 */

@RestController
@RequestMapping("/api/exception")
class ExceptionApiController {

    @GetMapping("")
    fun hello() {
        val list = mutableListOf<String>()
        val temp = list[0]
    }

    // 작성 해놓은 컨트롤러에서만 사용하고 싶을 때
    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String> {
        println("Controller exception handler !!!!")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }

}