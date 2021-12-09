package com.example.palatex.POJO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// This user schema for map value from database
@Data
@Document("user")
public class user {
    @Id
    private String _id;
    private String firstname;
    private String lastname;
    private int memberID;

    public user (){}

    public user(String _id, String firstName, String lastName, int memberID){
        this._id = _id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.memberID = memberID;
    }


}
