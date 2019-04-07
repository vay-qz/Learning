package com.vay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/hello")
    public String helloworld(){
        System.out.println("hello");
        return "index.jsp";
    }

}
