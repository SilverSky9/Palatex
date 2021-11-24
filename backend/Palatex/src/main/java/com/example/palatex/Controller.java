package com.example.palatex;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class Controller {
    @RequestMapping("/test")
    public String test(){
        return "Hi! Test";
    }
    @RequestMapping("/getPrice")
    public String getPrice(){
        return "Price is ...";
    }
}
