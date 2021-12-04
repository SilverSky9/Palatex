package com.example.palatex.Controller;

import com.example.palatex.POJO.user;
import com.example.palatex.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {
    @Autowired
    private userService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(){
        List<user> users = userService.returnAllUsers();
        return ResponseEntity.ok(users);
    }
}
