package com.example.palatex.Aggregate;

import com.example.palatex.POJO.Transaction;
import com.example.palatex.POJO.Transaction_write;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.palatex.Repository.transactionWriteRepository;

public class transactionAggregate{

    @Autowired
    private transactionWriteRepository transactionWriteRepository;


    public Transaction_write  handleCreateTransactionCommand(CreateTransactionCommand command){
        Transaction_write transaction = new Transaction_write(command.getUser_id(), command.getDate(), command.getPrice_buy(), command.getTotal_price(), command.getUnit());
        transactionWriteRepository.save(transaction);

        return transaction;
    }


}
