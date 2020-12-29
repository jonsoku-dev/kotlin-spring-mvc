package com.tamastudy.kotlinespringbootmvc.controller.page

import com.tamastudy.kotlinespringbootmvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {
    @GetMapping("/main")
    fun main(): String {
        return "main.html"
    }

    @ResponseBody // 일반 controller 에서 rest controller 기능을 사용하고 싶을 때
    @GetMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            this.name = "Jon"
        }
    }
}