package com.example.palatex.Repository;

import com.example.palatex.POJO.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

// This repository interface for custom repository
@Repository
public interface userRepository extends MongoRepository<user, String> {
    //Now we don't have a custom repository yet.
}
