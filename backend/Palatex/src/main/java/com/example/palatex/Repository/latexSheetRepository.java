package com.example.palatex.Repository;

import com.example.palatex.POJO.LatexSheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface latexSheetRepository extends MongoRepository<LatexSheet, String> {
    @Query(value = "{_id:'?0'}")
    public LatexSheet findAllById(String id);
    public void deleteById(String id);
}
