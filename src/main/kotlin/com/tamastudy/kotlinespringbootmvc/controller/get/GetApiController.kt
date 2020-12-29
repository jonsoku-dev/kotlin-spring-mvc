package com.tamastudy.kotlinespringbootmvc.controller.get

import com.tamastudy.kotlinespringbootmvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
public class GetApiController {
    @GetMapping("/hello")
    fun hello(): String {
        return "hello kotlin"
    }

    @GetMapping(path = ["/hello", "/abcd"]) // 여러개의 path 를 줄 수 있다.
    fun helloWithPath(): String {
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping-path-variabled/jon
    fun pathVariable(@PathVariable(value = "name") _name: String, @PathVariable age: Int): String {
        println("$_name, $age")
        return "$_name $age"
    }

    // https://localhost:8080/api/page?key=value&key=value
    // query parameter => 보통 pagination 의 filter 옵션을 query parameter 로 받는다.
    @GetMapping("/get-mapping/query-param") // ?name=jon&age=28
    fun queryParam(
            @RequestParam name: String,
            @RequestParam(value = "age") age: Int
    ): String {
        println("$name, $age")
        return "$name $age"
    }

    // Query Param 1. dto 로 받는 방식. 정해진 규칙 내에서 받을 수 있다.
    // name, age, address, email
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    // Query Param 2. Map 으로 받는 방식, 무한대로 받을 수 있다.
    // name, age, address, email, phone, ...
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamObject(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map["phone"]
        return map
    }
}