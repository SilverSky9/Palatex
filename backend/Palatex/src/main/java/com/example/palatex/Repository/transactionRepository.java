package com.example.palatex.Repository;

import com.example.palatex.POJO.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface transactionRepository extends MongoRepository<Transaction, String> {
    @Query(value = "{_id:'?0'}")
    public Transaction findAllById(String id);
}
