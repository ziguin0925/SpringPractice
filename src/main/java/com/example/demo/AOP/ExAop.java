package com.example.demo.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


//없어도 됨.
//@ComponentScan
//@Configuration
//@EnableAspectJAutoProxy
//class Config{
//
//}

//proxy 이므로 프록시를 통해 실제 객체 호출.
@Aspect
@Component
class LoggingAdvice{
    @Around("execution(* com.example.demo.BasicPackage.HelloController.main(..))")
    public Object methodClassLog(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aop start");
        try{
            Object result= pjp.proceed();//실제 객체\
            System.out.println("aop end");
            return result;
        }catch (Exception e){
            System.out.println("aop exception");
            e.printStackTrace();
            throw e;
        }
    }
}
