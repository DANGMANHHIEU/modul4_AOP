package com.example.aopspringboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @After("execution(* com.example.aopspringboot.controller.UserController.*(..))")
    public void logAfterMethod(JoinPoint joinPoint){
     String nameMethod = joinPoint.getSignature().getName();
     logger.info("\u001B[31mTên phương thức " + nameMethod + "\u001B[0m");
    }
}
