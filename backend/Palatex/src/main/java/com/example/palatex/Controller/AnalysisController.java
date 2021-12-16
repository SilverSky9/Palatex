package com.example.palatex.Controller;

import com.example.palatex.POJO.Latex;
import com.example.palatex.POJO.Transaction;
import com.example.palatex.POJO.User;
import com.example.palatex.POJO.allAnalysis;
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
    ArrayList<User> users = new ArrayList<>();

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/tran/all", method = RequestMethod.GET)
    public ArrayList<Transaction> getTransaction() {
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
    public ArrayList<Latex> getAllLatex(){
        Object out = rabbitTemplate.convertSendAndReceive("sop", "allLatex", latexs);
        return (ArrayList<Latex>) out;
    }
    @RequestMapping(value = "latex/date/{date}", method = RequestMethod.GET)
    public String getLatexByDate(){

        return "test";

    }

    public ArrayList<User> getAllUser(){

        Object out = rabbitTemplate.convertSendAndReceive("sop", "allUser", users);

        return (ArrayList<User>) out;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET) // Maybe Not Use This Method
    public String getAllAnalysis(){
        Double price;
        String _id, user_id, name, transaction_id;
        ArrayList<Transaction> transactions = new ArrayList<>();
        ArrayList<Latex> latexPrices = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();


        transactions = this.getTransaction();
        latexPrices = this.getAllLatex();
        users = this.getAllUser();

        for (Transaction transaction: transactions) {
            for (User user: users ) {
                System.out.println("Member id:" + user.getMemberId());
                System.out.println("user_id" +  transaction.getUser_id());
                if(transaction.getUser_id() == user.getMemberId()){
                    System.out.println(user.getFirstname() + user.getLastname());
                    System.out.println("in");
                }

            }
        }


    return "test";


    }
}
