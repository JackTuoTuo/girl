package com.girl.repository

import com.girl.domain.JavaGirl
import com.girl.domain.KotlinGirl
import org.springframework.data.jpa.repository.JpaRepository

interface JavaGirlRepository : JpaRepository<JavaGirl, Int>

interface KotlinGirlRepository : JpaRepository<KotlinGirl, Int> {
    fun findByAge(age: Int): List<KotlinGirl>
}