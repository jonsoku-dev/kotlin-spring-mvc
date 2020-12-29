package com.tamastudy.kotlinespringbootmvc.annotation

import com.tamastudy.kotlinespringbootmvc.validator.StringFormatDateTimeValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [StringFormatDateTimeValidator::class])
@Target(
        AnnotationTarget.FIELD,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class StringFormatDateTime(
        val pattern: String = "yyyy-MM-dd HH:mm:ss",
        val message: String = "시간 형식이 유효하지 않습니다",

        // default 로 annotation 에 들어가는 부분이라 그냥 외우자;
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = [],
)
