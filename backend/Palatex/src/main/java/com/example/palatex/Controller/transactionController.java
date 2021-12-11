package com.example.palatex.Controller;

import com.example.palatex.POJO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.palatex.Service.transactionService;
import com.example.palatex.POJO.Transaction;

import java.util.List;

@RestController
public class transactionController {
    @Autowired
    private transactionService transactionService;

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTransaction(){
        List<Transaction> transactions = transactionService.getAllTransactionService();
        return  ResponseEntity.ok(transactions);
    }
    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTransactionById(@PathVariable("id") String id){

        Transaction transaction = transactionService.getTransactionByIdService(id);
        return  ResponseEntity.ok(transaction);

    }



}
