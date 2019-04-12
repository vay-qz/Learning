package com.vay.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cook {

    public void doFish(){
        System.out.println("doCook");
    }

    public void doVagetable(){
        System.out.println("doCook");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Cook c = (Cook)applicationContext.getBean("cook");
        c.doFish();
    }
}
