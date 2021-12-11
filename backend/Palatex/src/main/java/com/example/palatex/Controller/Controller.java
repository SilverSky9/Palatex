package com.example.palatex.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;


@RestController
public class Controller {

    //This router for test something
    @RequestMapping("/test")
    public String test(){
        return "Hi! Test";
    }

    //This router for get price for external API
    @RequestMapping("/getPrice")
    public Mono<String> getPrice(){


        WebClient webClient = WebClient.create("http://dataapi.moc.go.th");


        Mono<String> test = webClient.get()
                .uri("/gis-product-prices?product_id=W16025&from_date=2021-12-08&to_date=2021-12-08")
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(String.class);
//        Mono<String> out = webClient2.get()
//                .uri("gis-product-prices?product_id=W16025&from_date=2021-12-08&to_date=2021-12-08")
//                .retrieve()
//                .bodyToMono(String.class);
//        WebClient webClient = WebClient.create();
//        String responseJson = webClient.get()
//                .uri("http://dataapi.moc.go.th/gis-product-prices?product_id=W16025&from_date=2021-12-08&to_date=2021-12-08")
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();

        return test;
    }
}

