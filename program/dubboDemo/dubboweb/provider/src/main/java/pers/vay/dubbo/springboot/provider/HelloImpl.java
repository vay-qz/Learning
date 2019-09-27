package pers.vay.dubbo.springboot.provider;

import org.apache.dubbo.config.annotation.Service;
import pers.vay.dubbo.inf.Hello;

@Service
public class HelloImpl implements Hello {

    @Override
    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

}
