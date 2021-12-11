package com.example.palatex.POJO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// This user schema for map value from database
@Getter
@Setter

@Data
@Document("user")
public class User {
    @Id
    private String _id;
    private int memberId;
    private String firstname;
    private String lastname;
//    private String phone_number;
//    private String username;
//    private String password;

    public User(){}

    public User(String _id, int memberId, String firstname, String lastname){
        this._id = _id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.memberId = memberId;

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
