package com.example.palatex.Repository;

import com.example.palatex.POJO.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends MongoRepository<user, String> {

}
