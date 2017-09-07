package com.girl.service


import com.girl.domain.JavaGirl
import com.girl.domain.KotlinGirl
import com.girl.domain.Result
import com.girl.enums.ResultEnum
import com.girl.exception.GirlException
import com.girl.repository.JavaGirlRepository
import com.girl.repository.KotlinGirlRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import org.springframework.transaction.annotation.Transactional


@Service
class GirlService {

    @Autowired
    private lateinit var javaGirlRepository: JavaGirlRepository

    @Autowired
    private lateinit var kotlinGirlRepository: KotlinGirlRepository


    fun findAllKotlinGirls(): List<KotlinGirl>? = kotlinGirlRepository.findAll()

    fun findAllJavaGirls(): List<JavaGirl>? = javaGirlRepository.findAll()


    fun save(kotlinGirl: KotlinGirl?): KotlinGirl? = kotlinGirlRepository.save(kotlinGirl)

    fun findKotlinGirlById(id: Int): KotlinGirl? = kotlinGirlRepository.findOne(id)

    fun updateKotlinGirl(kotlinGirl: KotlinGirl?): KotlinGirl? = kotlinGirlRepository.save(kotlinGirl)

    fun deleteKotlinGirlById(id: Int) = kotlinGirlRepository.delete(id)

    fun findKotlinGirlByAge(age: Int): List<KotlinGirl>? = kotlinGirlRepository.findByAge(age)

    @Transactional
    fun insertTwo() {
        val oneGirl = KotlinGirl(cupSize = "D", age = 17, money = 100.00)
        val towGirl = KotlinGirl(cupSize = "F", age = 18, money = 200.00)

        kotlinGirlRepository.save(oneGirl)

        kotlinGirlRepository.save(towGirl)
    }

    fun getKotlinGirlAgeById(id: Int): Result<Any> {
        val girl = kotlinGirlRepository.findOne(id)
        return when (girl.age) {
            in 0..10 -> throw GirlException(ResultEnum.PRIMARY_SCHOOL)
            in 10..16 -> throw GirlException(ResultEnum.MIDDLE_SCHOOL)
            else -> throw GirlException(ResultEnum.BIG_SCHOOL)
        }
    }
}