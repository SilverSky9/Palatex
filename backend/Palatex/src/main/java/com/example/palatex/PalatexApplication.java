package com.example.palatex;

import com.example.palatex.POJO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.palatex.Repository.authRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class PalatexApplication {
@Autowired
private authRepository authRepository;

public void initUser() {
    List<User> users = Stream.of(
            new User(null, 5, "","","", "farrock", "heart555")
    ).collect(Collectors.toList());
    authRepository.saveAll(users);
}


    public static void main(String[] args) {
        SpringApplication.run(PalatexApplication.class, args);
    }



//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMapping(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE")
//                        .allowedHeaders("*")
//                        .allowedOrigins("http://localhost:3000");
//            }
//        };
//    }

}
