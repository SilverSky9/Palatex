package com.example.palatex.Service;

import com.example.palatex.POJO.User;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.palatex.Repository.authRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class userAuthService implements UserDetailsService {
    @Autowired
    private authRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authRepository.findByUsername(username);
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>(); // use list if you wish
//        for (User role : user.getRole()) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getUsername()));
//        }

//        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
//
//        for (int i=0; i<user.getRole().size();i++)
//        {
//
//            JsonObject jsonObject = new JsonObject(user.getRoles().get(i));
//            String role = jsonObject.("role".toString());
//            gas.add(new SimpleGrantedAuthority(role));
//        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
         }
}
