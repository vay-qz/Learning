package com.vay.anno.InitParamAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class InitController {

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(userValidator);
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public String login(@Validated @RequestBody User user){
        return "login";
    }

    @RequestMapping("/model")
    public void testModel(Model model){
        Map a = model.asMap();
        System.out.println("className:" + a.get("className"));
        System.out.println("model2:" + a.get("model2"));
        System.out.println("string:" + a.get("string"));
    }

    @ModelAttribute("className")
    public String setModel() {
        return this.getClass().toString();
    }

    @ModelAttribute
    public void setModel1(Model m) {
        m.addAttribute("model2", "model2");
    }

    @ModelAttribute
    public String setModel2() {
        return "string";
    }

}
