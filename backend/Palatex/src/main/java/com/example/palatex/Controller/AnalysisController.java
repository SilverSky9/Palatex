package com.example.palatex.Controller;

import com.example.palatex.POJO.Latex;
import com.example.palatex.POJO.Transaction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping(value = "/analysis")
public class AnalysisController {
    ArrayList<Transaction> transactions = new ArrayList<>();
    ArrayList<Latex> latexs = new ArrayList<>();

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/tran/all", method = RequestMethod.GET)
    public List<Transaction> getSumMoney() {
        Object out = rabbitTemplate.convertSendAndReceive("sop", "allTran", transactions);
        return (ArrayList<Transaction>) out;
    }

    @RequestMapping(value = "/date/{method}/{start}/{end}", method = RequestMethod.GET)
    public String analysisByDate(@PathVariable String start, @PathVariable String end, @PathVariable String method){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String newDate = simpleDateFormat.format(new Date());


        ArrayList<Transaction> list = new ArrayList<>();
        Object out = rabbitTemplate.convertSendAndReceive("sop", "allTran", transactions);
        list = (ArrayList<Transaction>) out;

//        if(list.get(0).getDate().equals(StartDate)){
//            System.out.println("Found!");
//        }
//        System.out.println(list);


        Date date = new Date();
        if(method == "max"){

        }
        else if(method == "min"){

        }

//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String newDate = simpleDateFormat.format(new Date());
        return start + " " + end + " " + method + " " + newDate;
    }
    @RequestMapping(value = "/latex/all", method = RequestMethod.GET)
    public List<Latex> getAllLatex(){
        Object out = rabbitTemplate.convertSendAndReceive("sop", "allLatex", latexs);
        return (ArrayList<Latex>) out;
    }
}
