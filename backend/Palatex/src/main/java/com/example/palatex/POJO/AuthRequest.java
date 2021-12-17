package com.example.palatex.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthRequest  {
//    String ROLE_PREFIX = "ROLE_";

    private String username;
    private String password;
    private String role;

//    public AuthRequest(String username, String password, String role) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
//
//        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
//
//        return list;
//    }
}
