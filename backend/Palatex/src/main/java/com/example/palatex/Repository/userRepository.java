package com.example.palatex.Repository;

import com.example.palatex.POJO.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

// This repository interface for custom repository
@Repository
public interface userRepository extends MongoRepository<User, String> {

    @Query( value = "{memberId: ?0}")
    public User findByMemberIdQuery(int id);
}
