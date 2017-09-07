package com.girl

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class GirlApplication

fun main(args: Array<String>) {
    SpringApplication.run(GirlApplication::class.java, *args)
}
