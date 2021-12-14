package com.example.palatex.Controller;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@RestController
public class Controller {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //This router for test something
    @RequestMapping("/test")
    public String test(){
        return "Hi! Test";
    }

    //This router for get price for external API
    @RequestMapping("/getTest")
    public String getPrice(){
        return "test";
    }

//    @RequestMapping("/message")
//    public void testMessage(){
//        rabbitTemplate.convertAndSend("sop", "tester", "Golf");
//    }
}

