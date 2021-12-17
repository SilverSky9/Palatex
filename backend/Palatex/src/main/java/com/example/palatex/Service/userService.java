package com.example.palatex.Service;

import com.example.palatex.POJO.User;
import com.example.palatex.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//This user mirco service
@Service
public class userService {
    @Autowired
    private static userRepository userRepository;
    @Autowired


    public userService(userRepository userRepository){
        this.userRepository = userRepository;
    }
    //Add user
    public User addUserService(User u) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(u.getPassword());

        System.out.println(encodedPassword);

        u.setPassword(encodedPassword);
        return userRepository.save(u);
    }
    //Get all user
    public List<User> getAllUsersService(){
        return userRepository.findAll();
    }
    //Get by ID
    public User getUserByMemberIdService(int memberId) {
        return userRepository.findByMemberIdQuery(memberId);
    }
    //Get count all user
    public int countAllUserService(){
        return (int) userRepository.count();
    }
    //Delete user
    public boolean deleteUserDataService(String id){
        try {
            userRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static User getUserByUsernameService(String u) {
        return userRepository.findUserByUsername(u);
    }
}
