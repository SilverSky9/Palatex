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
//        WebClient.ResponseSpec out = WebClient.create("https://dataapi.moc.go.th")
//                .get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/gis-product-prices")
//                        .queryParam("product_id", "W16025")
//                        .queryParam("from_date", "2018-11-01")
//                        .queryParam("to_date", "2018-11-24")
//                        .build())
//                .retrieve();
        WebClient webClient = WebClient.create();
        String responseJson = webClient.get()
                .uri("https://dataapi.moc.go.th/gis-product-prices?product_id=W16025&from_date=2018-11-01&to_date=2018-11-24")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return responseJson;
    }
}
