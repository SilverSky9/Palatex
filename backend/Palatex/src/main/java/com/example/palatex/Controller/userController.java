package com.example.palatex.Controller;

import com.example.palatex.POJO.User;
import com.example.palatex.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

//User router for query data
@RestController
public class userController {
    @Autowired
    private userService userService;

    @RequestMapping(value = "/getalluser", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUser(){
        List<User> users = userService.getAllUsersService();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/adduser/{memberId}/{firstname}/{lastname}", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@PathVariable("memberId") int memberId,
                                     @PathVariable("firstname") String firstname,
                                     @PathVariable("lastname") String lastname){

        User u = userService.addUserService(new User(null, memberId, firstname, lastname));
        return ResponseEntity.ok(u);
    }

    @RequestMapping(value = "/findbymemberid/{memberId}", method = RequestMethod.GET)
    public ResponseEntity<?> addUser(@PathVariable("memberId") int memberId){

        User u = userService.getUserByMemberIdService(memberId);
        return ResponseEntity.ok(u);
    }
}
