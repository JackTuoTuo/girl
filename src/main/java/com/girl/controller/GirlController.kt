package com.girl.controller

import com.girl.domain.KotlinGirl
import com.girl.domain.Result
import com.girl.enums.ResultEnum
import com.girl.exception.GirlException
import com.girl.service.GirlService
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class GirlController {

    @Autowired
    private lateinit var girlService: GirlService


    @GetMapping(path = arrayOf("/java/girls"))
    fun getJavaGirls(): Result<Any> {
        return Result.success(girlService.findAllJavaGirls())
    }


    @GetMapping(path = arrayOf("/kotlin/girls"))
    fun getKotlinGirls(): Result<Any> {
        return Result.success(girlService.findAllKotlinGirls())
    }


    @PostMapping(path = arrayOf("/kotlin/girls"))
    fun girlAdd(@Valid kotlinGirl: KotlinGirl, bindingResult: BindingResult): Result<Any> {
        if (bindingResult.hasErrors()) {
            println(bindingResult.fieldError.defaultMessage)
            return Result.error(1, bindingResult.fieldError.defaultMessage)
        }
        return Result.success(girlService.save(kotlinGirl))
    }

    @GetMapping(path = arrayOf("/kotlin/girls/{id}"))
    fun getGirlById(@PathVariable("id") id: Int): Result<Any> {
        return Result.success(girlService.findKotlinGirlById(id))
    }

    @PutMapping(path = arrayOf("kotlin/girls/{id}"))
    fun updateGirl(@PathVariable("id") id: Int, @RequestParam("cupSize") cupSize: String, @RequestParam("age") age: Int, @RequestParam("money") money: Double): Result<Any> {
        return try {
            val girl = girlService.findKotlinGirlById(id)
            if (girl !== null) {
                girl.cupSize = cupSize
                girl.age = age
                girl.money = money
                Result.success(girlService.updateKotlinGirl(girl))
            } else {
                throw GirlException(ResultEnum.NOT_FIND)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

    @DeleteMapping(path = arrayOf("kotlin/girls/{id}"))
    fun deleteGirlById(@PathVariable("id") id: Int): Result<Any> {
        girlService.deleteKotlinGirlById(id)
        return Result.success("")
    }

    @GetMapping(path = arrayOf("kotlin/girls/age/{age}"))
    fun findGirlByAge(@PathVariable("age") age: Int): Result<Any> {
        return Result.success(girlService.findKotlinGirlByAge(age))
    }

    @GetMapping(path = arrayOf("kotlin/girls/insert"))
    fun insert(): Result<Any> {
        girlService.insertTwo()
        return Result.success("")
    }

    @GetMapping(path = arrayOf("kotlin/girls/getAge/{id}"))
    fun getKotlinGirlAgeById(@PathVariable("id") id: Int): Result<Any> {
        return try {
            girlService.getKotlinGirlAgeById(id)
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }


}