package com.example.palatex.Controller;

import com.example.palatex.POJO.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.palatex.Service.transactionService;
import com.example.palatex.POJO.Transaction;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class transactionController {
    @Autowired
    private transactionService transactionService;

    //Get All transaction in mongoDB
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTransaction(){
        List<Transaction> transactions = transactionService.getAllTransactionService();
        return  ResponseEntity.ok(transactions);
    }
    //Get transaction by transaction_id
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTransactionById(@PathVariable("id") String id){

        Transaction transaction = transactionService.getTransactionByIdService(id);
        return  ResponseEntity.ok(transaction);

    }
    //Save transaction to mongoDB
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction){
        transactionService.addTransactionService(transaction);
        return ResponseEntity.ok("Save!");
    }
    // Count all transaction in mongoDB
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public  ResponseEntity<?> countAllTransaction(){
        return ResponseEntity.ok(transactionService.countAllTransactionService());
    }
    // Delete Transaction by ID in mongoDB
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delTransaction(@PathVariable String id){
        transactionService.deleteTransactionService(id);
        return ResponseEntity.ok("Delete transaction!");
    }

    @RabbitListener(queues = "transaction")
    public ArrayList<Transaction> getAllTransaction(ArrayList list){
        List<Transaction> transactions =  transactionService.getAllTransactionService();
        list.addAll(transactions);
        return list;
    }

}
