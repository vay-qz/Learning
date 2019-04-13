package com.vay.aop.controller;

import com.vay.aop.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InnerController {

    @Autowired
    private MockService mockService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return mockService.hello();
    }

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

}
