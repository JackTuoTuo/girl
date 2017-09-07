package com.girl.enums

enum class ResultEnum(val code: Int, val message: String) {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    NOT_FIND(99, "该女生不存在"),
    PRIMARY_SCHOOL(100, "你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能还在上初中"),
    BIG_SCHOOL(102, "你可以还在上大学")
}