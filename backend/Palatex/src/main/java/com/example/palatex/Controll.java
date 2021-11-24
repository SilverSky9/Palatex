package com.example.palatex;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controll {
    @RequestMapping("/test")
    public String test(){
        return "Hi! Test";
    }
}
