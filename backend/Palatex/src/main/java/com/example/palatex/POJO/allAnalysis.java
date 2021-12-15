package com.example.palatex.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter


@Data
public class allAnalysis {
    @Id
    String _id;
    String transaction_id;
    String user_id;
    String name;
    double price;
}
