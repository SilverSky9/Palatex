package com.example.palatex.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.palatex.Repository.transactionRepository;
import com.example.palatex.POJO.Transaction;

import java.util.List;

@Service
public class transactionService {
    @Autowired
    private transactionRepository transactionRepository;

    public transactionService(transactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    public Transaction addTransactionService(Transaction t){
        return transactionRepository.save(t);
    }
    public List<Transaction> getAllTransactionService(){
        return transactionRepository.findAll();
    }
}
