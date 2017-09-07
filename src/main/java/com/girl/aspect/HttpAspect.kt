package com.girl.aspect

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


@Aspect
@Component
class HttpAspect {

    private val logger: Logger by lazy { LoggerFactory.getLogger(HttpAspect::class.java) }

    @Pointcut("execution(* com.girl.controller.GirlController.*(..))")
    fun log() = Unit

    /**
     * 记录请求
     */
    @Before("log()")
    fun doBefore(joinPoint: JoinPoint) {
        val attributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val request = attributes.request
        logger.info("url={}", request.requestURL)
        logger.info("method={}", request.method)
        logger.info("ip={}", request.remoteAddr)
        logger.info("class-method={}", "${joinPoint.signature.declaringTypeName}.${joinPoint.signature.name}")
        logger.info("args={}", joinPoint.args)
    }

    /**
     * 记录结果
     */
    @After(value = "log()")
    fun doAfter() {
        logger.info("5678")
    }

    @AfterReturning(returning = "any", pointcut = "log()")
    fun doAfterReturning(any: Any) {
        logger.info("response={}", any)
    }

}