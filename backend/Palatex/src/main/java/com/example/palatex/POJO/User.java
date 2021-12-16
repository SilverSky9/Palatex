package com.example.palatex.POJO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

// This user schema for map value from database
@Getter
@Setter

@Data
@Document("user")
public class User implements Serializable {
    @Id
    private String _id;
    private int user_id;
    private String firstname;
    private String lastname;
    private String phone_number;
    private String username;
    private String password;
    private String role = "user";

    public User(){}

    public User(String _id, int user_id, String firstname, String lastname, String phone_number, String username, String password){
        this._id = _id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.user_id = user_id;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
        this.role = "user";

    }

//    public User(String _id, int memberId, String firstname, String lastname, String phone_number,String username, String password){
//        this._id = _id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.memberId = memberId;
//        this.phone_number = phone_number;
//        this.username = username;
//        this.password = password;
//    }


}
