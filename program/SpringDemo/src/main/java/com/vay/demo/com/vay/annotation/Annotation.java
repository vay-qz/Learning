package com.vay.demo.com.vay.annotation;

import org.springframework.web.bind.annotation.*;

/**
 * @author qiaozhe
 */
@RestController
public class Annotation {

    @PostMapping("/testPost")
    public void testPost(
            @RequestBody String body,
            @RequestParam String param,
            @RequestHeader String header
    ){
        System.out.println("test");
        System.out.println(body);
        System.out.println(param);
        System.out.println(header);
    }

    @GetMapping("/testGet")
    @PostMapping
    public void testGet(
            //get没有body
//            @RequestBody String body
            @RequestParam String param,
            @RequestHeader String header
    ){
        System.out.println("test");
//        System.out.println(body);
        System.out.println(param);
        System.out.println(header);
    }

    @GetMapping("/testAttr")
    public void testAttr(
            @RequestAttribute String attr
    ){
        System.out.println(attr);
    }

    @RequestMapping(value="/value",method = RequestMethod.GET, params = "param=myValue" ,headers="header=1")
    public void testReqAnno(){
        System.out.println("req");
    }
    @RequestMapping(value="/value",method = RequestMethod.GET, params = "param=myValue2",headers="header=2")
    public void testReqAnno2(){
        System.out.println("req2");
    }
    @RequestMapping(value="/value",method = RequestMethod.GET, params = "param=myValue" ,headers="header=2")
    public void testReqAnno3(){
        System.out.println("req3");
    }

    @RequestMapping(value="/value",method = RequestMethod.POST, params = "param=myValue" ,headers="header=1")
    public void testReqAnno5(){
        System.out.println("req5");
    }
    @RequestMapping(value="/value",method = RequestMethod.POST, params = "param=myValue2",headers="header=2")
    public void testReqAnno6(){
        System.out.println("req6");
    }
    @RequestMapping(value="/value",method = RequestMethod.POST, params = "param=myValue" ,headers="header=2")
    public void testReqAnno7(){
        System.out.println("req7");
    }

    @RequestMapping(value="/value", method = RequestMethod.POST, params = "param=1", consumes = "application/json")
    public void testReqAnno4(){
        System.out.println("req4");
    }

    @RequestMapping(value="/pro", method = RequestMethod.POST, produces = "application/json")
    public void testReqAnno11(){
        System.out.println(11);

    }

}
