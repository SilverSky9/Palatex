package com.example.palatex.POJO;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("transaction")
public class Transaction {
    @Id
    private String _id;
    private int transaction_id;
    private int user_id;
    private Date date;
    private float price_buy;
    private float total_price;
    private int unit;

    public Transaction() {}

    public Transaction(String _id,
                       int transaction_id,
                       int user_id,
                       Date date,
                       float price_buy,
                       float total_price,
                       int unit) {

        this._id = _id;
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.date = date;
        this.price_buy = price_buy;
        this.total_price = total_price;
        this.unit = unit;

    }
}
