package com.girl.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Min




@Entity
data class KotlinGirl(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = -1,
        var cupSize: String,
        @Min(value = 18.toLong(), message = "未成年少女不得入内")
        var age: Int,
        var money: Double
)