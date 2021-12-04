package com.example.palatex.Service;

import com.example.palatex.POJO.user;
import com.example.palatex.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//This user mirco service
@Service
public class userService {
    @Autowired
    private userRepository repository;

    public userService(userRepository repository){
        this.repository = repository;
    }
    public List<user> returnAllUsers(){
        return repository.findAll();
    }

}
