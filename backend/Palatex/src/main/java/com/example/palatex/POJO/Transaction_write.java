package com.example.palatex.POJO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("transaction_write")
public class Transaction_write {
    @Id
    private String _id;
    private String user_id;
    private java.util.Date date; //not sure
    private double price_buy;
    private double total_price;
    private double unit;

//    public Transaction_write(){}

    public Transaction_write(String user_id, Date date, double price_buy, double total_price, double unit ){
        this.user_id = user_id;
        this.date = date;
        this.price_buy = price_buy;
        this.total_price = total_price;
        this.unit = unit;

    }
}
