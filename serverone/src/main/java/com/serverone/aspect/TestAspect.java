package com.serverone.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Create By CJH on 2018/5/28
 */
@Aspect
@Component
public class TestAspect {
    @Pointcut("execution(public * com.serverone.controller.*.*(..))")
    public void point () {
//        System.out.println("cut!!!!");
    }

    @Before("point()")
    public void beforeCut (JoinPoint joinPoint) {
        System.out.println("cut!!!!");
    }

    @AfterReturning(returning = "ret", pointcut = "point()")
    public void returnCut (Object ret) {
        System.out.println(ret);
    }
}