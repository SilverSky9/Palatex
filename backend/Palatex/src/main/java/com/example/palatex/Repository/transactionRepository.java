package com.example.palatex.Repository;

import com.example.palatex.POJO.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface transactionRepository extends MongoRepository<Transaction, String> {
    @Query(value = "{_id:'?0'}")
    public Transaction findAllById(String id);
    public void deleteById(String id);

    @Query("{'date' : { $gte: ?0, $lte: ?0 } }")
    public List<Transaction> findTransactionBy_date(Date date);

}
