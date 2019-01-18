package com.yunus.aspect;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectFoo {

    @Pointcut("@annotation(com.yunus.annotation.Login)")
    public void point() {

    }

    @Before("point()")
    public void before() {
        System.out.println("切面类--before方法执行");
    }

    @After("point()")
    public void after() {
        System.out.println("切面类--after方法执行");
    }

    //@Around("point()")
    public void around() {
        System.out.println("切面类--around方法执行");
    }
}
