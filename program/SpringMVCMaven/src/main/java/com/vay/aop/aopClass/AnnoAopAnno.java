package com.vay.aop.aopClass;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnoAopAnno {

    @Around("@annotation(com.vay.aop.aopClass.anno.AroundAnno)")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("auditBefore");
            proceedingJoinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    @Pointcut("@annotation(com.vay.aop.aopClass.anno.AfterAnno)")
    public void pointCut(){

    }

    @After("pointCut()")
    public void after(){
        System.out.println("after");
    }
}
