package com.example.palatex.Controller;

import com.example.palatex.Security.Entity.AuthRequest;
import com.example.palatex.Security.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
@Autowired
private JwtUtil jwtUtil;
@Autowired
private AuthenticationManager authenticationManager;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hee(){
        return "kuyprayuth";
    }

    @RequestMapping(value = "/authen", method = RequestMethod.POST)
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
    }catch (Exception e) {
        throw new Exception("invalid");
    }
    return jwtUtil.generateToken(authRequest.getUsername());

    }
}
