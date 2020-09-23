package com.retaily.common.web

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Authorized()

@Aspect
@Configuration
@ComponentScan
open class AuthAspect(@Autowired val sessionService: SessionService) {
    @Before("@annotation(com.retaily.common.web.Authorized)")
    fun before() {
        if (sessionService.getUserId() == null) throw NotInSessionException("Not in session")
    }
}
