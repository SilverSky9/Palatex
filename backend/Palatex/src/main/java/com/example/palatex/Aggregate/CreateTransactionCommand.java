package com.example.palatex.Aggregate;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateTransactionCommand {
    private String _id;
    private String user_id;
    private Date date;
    private double price_buy;
    private double total_price;
    private double unit;
}
