package com.example.palatex.POJO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document("price")
public class priceLatex {
    @Id
    private String product_id;
    private String product_name;
    private String product_desc_en;
    private String product_desc_th;
    private String category_name;
    private String group_name;
    private String unit;
    private double price_min_avg;
    private double price_max_avg;
    private ArrayList price_list;

}
