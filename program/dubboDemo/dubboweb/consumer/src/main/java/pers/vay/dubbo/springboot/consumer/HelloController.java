package pers.vay.dubbo.springboot.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.vay.dubbo.inf.Hello;

@RestController
public class HelloController {

    @Reference
    private Hello hello;

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("dubbo")
    public String dubbo() {
        System.out.println("hello");
        return hello.sayHello();
    }

}
