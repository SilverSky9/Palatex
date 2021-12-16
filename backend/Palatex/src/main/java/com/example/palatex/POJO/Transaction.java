package com.example.palatex.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDate;

@Getter
@Setter

@Data
@Document("transaction")
public class Transaction implements Serializable {
    @Id
    private String _id;
    private int user_id;
//    private int transaction_id;
    private LocalDate  date; //not sure
    private double price_buy;
    private double total_price;
    private double unit;

    public Transaction(){}


    public Transaction(String _id,int user_id, LocalDate  date, double price_buy, double total_price,double unit ){
        this._id = _id;

//        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.date = date;
        this.price_buy = price_buy;
        this.total_price = total_price;
        this.unit = unit;

    }
}
