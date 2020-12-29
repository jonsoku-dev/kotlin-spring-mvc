package com.tamastudy.kotlinespringbootmvc.model.http

import com.tamastudy.kotlinespringbootmvc.annotation.StringFormatDateTime
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

data class UserRequest(
        @field:NotEmpty
        @field:Size(min = 2, max = 8)
        var name: String? = null,

        @field:Positive
        var age: Int? = null,

        @field:Email
        var email: String? = null,

        @field:NotEmpty
        var address: String? = null,

        @field:Pattern(regexp = "^\\d{2,4}-\\d{3,4}-\\d{4}\$") // 정규식 검증
        var phoneNumber: String? = null,

//        @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
        @field:StringFormatDateTime
        var createdAt: String? = null // yyyy-MM-dd HH:mm:ss ex) 2020-10-02 13:00:00
) {

//    // Custom validate function
//    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다.")
//    private fun isValidCreatedAt(): Boolean {
//        return try {
//            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
}