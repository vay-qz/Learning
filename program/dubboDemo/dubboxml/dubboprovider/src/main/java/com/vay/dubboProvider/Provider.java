package com.vay.dubboProvider;

import com.vay.DubboInterface;
import org.springframework.stereotype.Component;

/**
 * @author qiaozhe
 */
@Component
public class Provider implements DubboInterface {

    @Override
    public String sayHello() {
        System.out.println("provider");
        return "Hello";
    }

}
