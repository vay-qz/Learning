package com.vay.anno.InitParamAnno;

import com.alibaba.fastjson.JSONObject;
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

    @PostMapping("/api/dzjz/createJp")
    public Object getJson() {
        String res = "{\n" +
                "\t\"data\": {\n" +
                "\t\t\"ah\": \"（2012）冀01民初90号\",\n" +
                "\t\t\"ay\": \"人格权纠纷\",\n" +
                "\t\t\"mc\": [{\n" +
                "\t\t\t\"DW\": \"诉讼地位\",\n" +
                "\t\t\t\"MC\": \"被告人姓名\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"DW\": \"诉讼地位\",\n" +
                "\t\t\t\"MC\": \"被告人姓名\"\n" +
                "\t\t}],\n" +
                "\t\t\"cymc\": {\n" +
                "\t\t\t\"cymc1\": \"审判长\",\n" +
                "\t\t\t\"cymc2\": \"审判员1\",\n" +
                "\t\t\t\"cymc3\": \"审判员2\",\n" +
                "\t\t\t\"cymc4\": \"书记员\",\n" +
                "\t\t\t\"cymc5\": \"法官助理\"\n" +
                "\t\t},\n" +
                "        \"cyjs\": {\n" +
                "\t\t\t\"cyjs1\": \"审判长\",\n" +
                "\t\t\t\"cyjs2\": \"审判员1\",\n" +
                "\t\t\t\"cyjs3\": \"审判员2\",\n" +
                "\t\t\t\"cyjs4\": \"书记员\",\n" +
                "\t\t\t\"cyjs5\": \"法官助理\"\n" +
                "\t\t},\n" +
                "\t\t\"jarq\": \"结案日期\",\n" +
                "\t\t\"sarq\": \"收案日期\",\n" +
                "\t\t\"bhfy\": \"报核法院\",\n" +
                "\t\t\"bhah\": \"报核案号\",\n" +
                "\t\t\"sxfhjg\": \"死刑复核结果\",\n" +
                "\t\t\"gdrq\": \"归档日期\"\n" +
                "\t}\n" +
                "}";
        Object a = JSONObject.parse(res);
        return a;
    }


}
