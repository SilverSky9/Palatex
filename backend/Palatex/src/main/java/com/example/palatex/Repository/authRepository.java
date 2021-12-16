package com.example.palatex.Repository;

import com.example.palatex.POJO.Latex;
import com.example.palatex.POJO.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface authRepository extends MongoRepository<User, String> {
    @Query(value = "{username:'?0'}")
    public User findByUsername(String username);
}
