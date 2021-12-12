package com.example.palatex.Repository;

import com.example.palatex.POJO.Latex;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface latexRepository extends MongoRepository<Latex, String> {

}
