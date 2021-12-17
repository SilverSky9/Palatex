package com.example.palatex.Service;

import com.example.palatex.POJO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.palatex.Repository.authRepository;
import java.util.ArrayList;

@Service
public class userAuthService implements UserDetailsService {
    @Autowired
    private authRepository authRepository;
    @Override
    public newUserDatails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authRepository.findByUsername(username);
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
        return new newUserDatails(user.getUsername(), user.getPassword(), user.getRole(), new ArrayList<>());
         }
}
