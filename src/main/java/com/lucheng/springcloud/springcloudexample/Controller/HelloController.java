package com.lucheng.springcloud.springcloudexample.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapping")
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
