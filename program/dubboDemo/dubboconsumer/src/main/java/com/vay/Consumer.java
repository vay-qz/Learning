package com.vay;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qiaozhe
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        DubboInterface dubboInterface = (DubboInterface) context.getBean(DubboInterface.class);
        System.out.println(dubboInterface.sayHello());
    }
}
