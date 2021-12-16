package com.example.palatex.Controller;


import com.example.palatex.POJO.priceLatex;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import lombok.val;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import javax.net.ssl.SSLException;
import java.time.LocalDate;


@RestController
public class Controller {

    @Autowired
    private WebClient webClient;

    private RabbitTemplate rabbitTemplate;

    //This router for test something
    @RequestMapping("/test")
    public String test() {
        return "Hi! SOP Palatex";
    }

    //This router for get price for external API
    @RequestMapping("/price")
    public double getPrice()  {


//        WebClient webClient = WebClient.create("https://dataapi.moc.go.th");
//
//
//        Mono<String> test = webClient.get()
//                .uri("/gis-product-prices?product_id=W16025&from_date=2021-12-08&to_date=2021-12-08")
////                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .retrieve()
//                .bodyToMono(String.class);
//        Mono<String> out = webClient2.get()
//                .uri("gis-product-prices?product_id=W16025&from_date=2021-12-08&to_date=2021-12-08")
//                .retrieve()
//                .bodyToMono(String.class);
//        WebClient webClient = WebClient.create();
        priceLatex responseJson = webClient.get()
                .uri("https://dataapi.moc.go.th/gis-product-prices?product_id=W16025&from_date=2021-12-16&to_date=2021-12-16")
                .exchange()
                .block()
                .bodyToMono(priceLatex.class)
                .block();
//        Mono<String> out = createWebClient2.create()
//                .get()
//                .uri("https://dataapi.moc.go.th/gis-product-prices?" + "?product_id=W16025&from_date=2021-12-08&to_date=2021-12-08")
//                .retrieve()
//                .bodyToMono(String.class);
////

        return responseJson.getPrice_max_avg();
    }

    @Bean
    public WebClient createWebClient2() throws SSLException {
        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        TcpClient tcpClient = TcpClient.create().secure(sslContextSpec -> sslContextSpec.sslContext(sslContext));
        HttpClient httpClient = HttpClient.from(tcpClient);
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
    }


//    @RequestMapping("/message")
//    public void testMessage(){
//        rabbitTemplate.convertAndSend("sop", "tester", "Golf");
//    }
}


