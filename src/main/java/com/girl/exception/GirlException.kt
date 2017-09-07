package com.girl.exception

import com.girl.enums.ResultEnum

class GirlException(resultEnum: ResultEnum) : RuntimeException(resultEnum.message) {
    val code: Int = resultEnum.code
    override val message: String = resultEnum.message
}