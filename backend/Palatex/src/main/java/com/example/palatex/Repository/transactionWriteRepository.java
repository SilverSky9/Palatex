package com.example.palatex.Repository;

import com.example.palatex.POJO.Transaction_write;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface transactionWriteRepository extends MongoRepository<Transaction_write, String> {


}