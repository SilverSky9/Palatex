package com.example.palatex.Repository;


import com.example.palatex.POJO.LatexSheetTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface latexSheetTransactionRepository extends MongoRepository<LatexSheetTransaction, String> {
}
