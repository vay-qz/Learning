package com.vay.aop.aopClass;

import org.springframework.stereotype.Component;

@Component
public class XmlAopClass {
    public void before(){
        System.out.println("xmlBefore1");
    }

}
