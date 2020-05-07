package com.wjq.demo.config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JpaAspect {
    @Pointcut("execution(public * com.wjq.demo.controller.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("前置通知");
    }

    @After("pointCut()")
    public void After(){
        System.out.println("后置通知");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获取controller的方法
        Object proceed = proceedingJoinPoint.proceed();
        System.err.println("proceed="+proceed);
        //类的信息
        String name = proceedingJoinPoint.getTarget().getClass().getName();
        System.err.println("name=" + name);
        //获取方法名称
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String name1 = signature.getMethod().getName();
        System.err.println("name1=" + name1);
        return proceed;
    }
}
