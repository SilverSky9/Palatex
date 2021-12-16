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
    private String user_id;
//    private int transaction_id;
    private LocalDate  date;
    private Date dateTime;
    private double price_buy;
    private double total_price;
    private double unit;

    public Transaction(){}


    public Transaction(String _id,String user_id, LocalDate  date,Date dateTime, double price_buy, double total_price,double unit ){
        this._id = _id;

//        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.date = date;
        this.dateTime = dateTime;
        this.price_buy = price_buy;
        this.total_price = total_price;
        this.unit = unit;

    }
}
