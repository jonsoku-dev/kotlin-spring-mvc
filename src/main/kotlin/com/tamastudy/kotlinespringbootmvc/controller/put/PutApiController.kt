package com.tamastudy.kotlinespringbootmvc.controller.put

import com.tamastudy.kotlinespringbootmvc.model.http.Result
import com.tamastudy.kotlinespringbootmvc.model.http.UserRequest
import com.tamastudy.kotlinespringbootmvc.model.http.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import java.lang.StringBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {
    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request put mapping"
    }

    @PutMapping(path = ["/put-mapping/object"])
    // @Valid 의 에러를  bindingResult 로 받을 수 있다.
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): ResponseEntity<String> {

        if (bindingResult.hasErrors()) {
            // 500 Error
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append("${field.field} : $message\n")
            }
            return ResponseEntity.badRequest().body(msg.toString());
        }

        return ResponseEntity.ok("OK")

        /**
         * apply 는 자기 자신을 return 한다. (체이닝)
         */
        // 0. Response
//        return UserResponse().apply {
//            // 1. result
//            this.result = Result().apply {
//                this.resultCode = "OK"
//                this.resultMessage = "Success"
//            }
//        }.apply {
//            // 2. description
//            this.description = "~~~~"
//        }.apply {
//            // 3. user mutable list
//            val userList = mutableListOf<UserRequest>()
//
//            userList.add(userRequest)
//
//            userList.add(UserRequest().apply {
//                this.name = "a"
//                this.age = 10
//                this.email = "a@gmail.com"
//                this.address = "a address"
//                this.phoneNumber = "010-1111-aaaa"
//            })
//
//            userList.add(UserRequest().apply {
//                this.name = "b"
//                this.age = 20
//                this.email = "b@gmail.com"
//                this.address = "b address"
//                this.phoneNumber = "010-1111-bbbb"
//            })
//
//            this.userRequest = userList
//        }
    }
}