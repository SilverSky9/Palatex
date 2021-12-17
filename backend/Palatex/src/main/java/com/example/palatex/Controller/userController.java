package com.example.palatex.Controller;

import com.example.palatex.POJO.User;
import com.example.palatex.Service.userService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

//User router for query data
@RestController
@RequestMapping(value = "/user")
public class userController {
    @Autowired
    private userService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //Get all user in mongoDB

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUser(){
        List<User> users = userService.getAllUsersService();
        return ResponseEntity.ok(users);
    }
    // Save user to mongoDB
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody  User user){
        userService.addUserService(user);
        return ResponseEntity.ok("Save user!");

    }
    // Get user data by ID in mongoDB
    @RequestMapping(value = "/id/{memberId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable("memberId") int memberId){

        User u = userService.getUserByMemberIdService(memberId);
        return ResponseEntity.ok(u);
    }
    //
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseEntity<?> countUser(){
        return ResponseEntity.ok(userService.countAllUserService());
    }

    //Delete user by ID in mongoDB
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delUser(@PathVariable String id){
        userService.deleteUserDataService(id);
        return ResponseEntity.ok("Delete user!");
    }
    @RequestMapping(value = "/testshit5/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByUsernameCon(@PathVariable String username){

        User u = userService.getUserByUsernameService(username);
        return ResponseEntity.ok(u.getFirstname());
    }

    @RabbitListener(queues = "GetAllUser")
    public ArrayList<User> getAllUser(ArrayList list){
        List<User> users = userService.getAllUsersService();
        list.addAll(users);
        return list;
    }

}
