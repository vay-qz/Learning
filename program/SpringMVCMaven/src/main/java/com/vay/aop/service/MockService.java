package com.vay.aop.service;

import com.vay.aop.aopClass.anno.AfterAnno;
import com.vay.aop.aopClass.anno.AroundAnno;
import org.springframework.stereotype.Service;

@Service
public class MockService {
    @AroundAnno
    @AfterAnno
    public String hello() {
        System.out.println("hello");
        return "hello";
    }
}
