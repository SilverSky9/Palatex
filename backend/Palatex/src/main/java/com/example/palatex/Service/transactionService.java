package com.example.palatex.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.palatex.Repository.transactionRepository;
import com.example.palatex.POJO.Transaction;


import java.util.Collections;
import java.util.List;

@Service
public class transactionService {
    @Autowired
    private transactionRepository transactionRepository;

    public transactionService(transactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    //Save transaction to mongoDB
    public Transaction addTransactionService(Transaction t){
        return transactionRepository.save(t);
    }
    //Get all transaction in mongoDB
    public List<Transaction> getAllTransactionService(){
        return transactionRepository.findAll();
    }
    //Get transaction by _id in mongoDB
    public Transaction getTransactionByIdService(String id){

        return transactionRepository.findAllById(id);

    }
}
