package com.example.palatex.Controller;

import com.example.palatex.POJO.User;
import com.example.palatex.Service.userService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

//User router for query data
@RestController
@RequestMapping(value = "/user")
public class userController {
    @Autowired
    private userService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUser(){
        List<User> users = userService.getAllUsersService();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody  User user){
        userService.addUserService(user);
        return ResponseEntity.ok("Save user!");

    }
//    public ResponseEntity<?> addUser(@PathVariable("memberId") int memberId,
//                                     @PathVariable("firstname") String firstname,
//                                     @PathVariable("lastname") String lastname){
//
//        User u = userService.addUserService(new User(null, memberId, firstname, lastname));
//        return ResponseEntity.ok(u);
//    }

    @RequestMapping(value = "/id/{memberId}", method = RequestMethod.GET)
    public ResponseEntity<?> addUser(@PathVariable("memberId") int memberId){

        User u = userService.getUserByMemberIdService(memberId);
        return ResponseEntity.ok(u);
    }
}
