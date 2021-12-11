package com.example.palatex.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class testService {

    @RabbitListener(queues = "tester")
    public void replyMessage(String n){
        System.out.println("It's message from backend " +  n);
    }
}
