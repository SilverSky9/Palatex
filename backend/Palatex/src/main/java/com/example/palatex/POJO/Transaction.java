package com.example.palatex.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Getter
@Setter

@Data
@Document("transaction")
public class Transaction {
    @Id
    private String _id;
    private int transaction_id;
    private Date date; //not sure
    private double price_buy;
    private double total_price;
    private double unit;

    public Transaction(){}

    public Transaction(String _id, int transaction_id, Date date, float price_buy, float total_price,float unit ){
        this._id = _id;
        this.transaction_id = transaction_id;
        this.date = date;
        this.price_buy = price_buy;
        this.total_price = total_price;
        this.unit = unit;

    }
}
