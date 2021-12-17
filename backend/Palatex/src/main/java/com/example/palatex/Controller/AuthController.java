package com.example.palatex.Controller;

import com.example.palatex.POJO.AuthRequest;
import com.example.palatex.POJO.User;
import com.example.palatex.Security.Util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.palatex.Service.userService;
import com.example.palatex.Repository.userRepository;
import com.example.palatex.Controller.userController;

@RestController
public class AuthController {
@Autowired
private JwtUtil jwtUtil;
@Autowired
private AuthenticationManager authenticationManager;
private userService userService;
private userRepository userRepository;
private userController userController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hee(){
        return "kuyprayuth";
    }

    @RequestMapping(value = "/authen", method = RequestMethod.POST)
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{

        User u = userService.getUserByUsernameService(authRequest.getUsername());
        System.out.println(u);

            //get role
            System.out.println(u.getPassword());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean isPasswordMatched = passwordEncoder.matches(authRequest.getPassword(), u.getPassword());
            System.out.println(isPasswordMatched);

            if (isPasswordMatched) {

                    System.out.println(authRequest.getPassword());
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), u.getPassword())
                    );
                return jwtUtil.generateToken(authRequest.getUsername(), u.getRole());

            }


//            User test = userService.getUserByUsernameService("Maysa");
//            System.out.println(test.getFirstname());

//    return "";
    return "";

    }

    @RequestMapping(value = "/checktoken/{t}", method = RequestMethod.GET)
    public Claims check(@PathVariable String t) {
        return jwtUtil.extractAllClaims(t);


    }
}
