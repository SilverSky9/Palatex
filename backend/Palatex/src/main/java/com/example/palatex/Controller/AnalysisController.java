package com.example.palatex.Controller;

import com.example.palatex.POJO.Transaction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnalysisController {
    ArrayList<Transaction> transactions;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/analysis/tran/all", method = RequestMethod.GET)
    public List<Transaction> getSumMoney() {
        transactions = new ArrayList<>();
        Object out = rabbitTemplate.convertSendAndReceive("sop", "tran", transactions);
        return (ArrayList<Transaction>) out;
    }

    @RequestMapping(value = "/analysis/{start}/{end}/{method}", method = RequestMethod.GET)
    public void analysisByDate(@PathVariable String start, @PathVariable String end, @PathVariable String method){
        if(method == "max"){
            
        }
        else if(method == "min"){

        }
    }
}
