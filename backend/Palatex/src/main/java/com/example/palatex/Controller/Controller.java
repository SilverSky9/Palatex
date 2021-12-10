package com.example.palatex.Controller;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import com.example.palatex.POJO.priceLatex;

@RestController
public class Controller {
    //This router for test something
    @RequestMapping("/test")
    public String test(){
        return "Hi! Test";
    }

    //This router for get price for external API
    @RequestMapping("/getTest")
    public Mono<String> getPrice(){


        WebClient webClient = WebClient.create("https://dataapi.moc.go.th");

        Mono<String> test = webClient.get()
                .uri("/gis-product-prices?product_id=W16025&from_date=2021-12-08&to_date=2021-12-08")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(String.class);
//        Mono<String> out = webClient2.get()
//                .uri("gis-product-prices?product_id=W16025&from_date=2021-12-08&to_date=2021-12-08")
//                .retrieve()
//                .bodyToMono(String.class);
//        WebClient webClient = WebClient.create();
//        priceLatex responseJson = webClient.get()
//                .uri("https://dataapi.moc.go.th/gis-product-prices?product_id=W16025&from_date=2018-11-01&to_date=2018-11-24")
//                .retrieve()
//                .bodyToMono(priceLatex.class)
//                .block();
        return test;
    }
}

