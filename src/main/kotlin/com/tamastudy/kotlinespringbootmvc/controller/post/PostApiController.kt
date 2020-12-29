package com.tamastudy.kotlinespringbootmvc.controller.post

import com.tamastudy.kotlinespringbootmvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {
    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "Post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request mapping"
    }

    // object mapper
    // json -> object
    // object -> json * spring 이 자동으로 변환작업해준다.
    @PostMapping("/post-mapping/object")
    fun postMappingObject(
            @RequestBody userRequest: UserRequest
    ): UserRequest {
        println(userRequest)
        return userRequest
    }
}