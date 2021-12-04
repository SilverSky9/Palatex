package com.example.palatex.POJO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
public class user {
    @Id
    private String _id;
    private String firstName;
    private String lastName;
    private String MemberID;

    public user (){}

    public user(String _id, String firstName, String lastName, String MemberID){
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.MemberID = MemberID;
    }


}
