package com.girl.domain


data class Result<T>(var code: Int, var message: String = "", var data: T? = null) {
    companion object {
        fun success(any: Any?): Result<Any> {
            return Result(0, "成功", any)
        }

        fun error(code: Int, message: String): Result<Any> {
            return Result(code, message)
        }
    }
}



