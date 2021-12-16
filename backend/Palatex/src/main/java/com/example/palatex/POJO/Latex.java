package com.example.palatex.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter

@Data
@Document("latex")
public class Latex implements Serializable {
    @Id
    private String _id;
//    private int latex_id;
    private double price;
    private LocalDate date;
    private Date dateTime;

    public Latex(){}

    public Latex(String _id, double price,LocalDate date, Date dateTime){
        this._id = _id;
//        this.latex_id = latex_id;
        this.price = price;
        this.date = date;
        this.dateTime = dateTime;


    }

}
