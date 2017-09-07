package com.girl.handle

import com.girl.domain.Result
import com.girl.exception.GirlException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

@ControllerAdvice
class ExceptionHandle {
    @ExceptionHandler(value = Exception::class)
    @ResponseBody
    fun handle(e: Exception): Result<Any> = when (e) {
        is GirlException -> Result.error(e.code, e.message)
        else -> {
            Result.error(-1, "未知异常")
        }
    }
}