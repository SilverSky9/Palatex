package com.example.palatex.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter

@Data
@Document("latex_sheet")
public class LatexSheet implements Serializable {

    @Id
    private String _id;
    private LocalDate date;
    private double sumUnit;
    private  double sumMoneyBuy;
    private  double weightToSheet;

    public LatexSheet(){}

    public LatexSheet( LocalDate date,double sumUnit, double sumMoneyBuy, double weightToSheet){

        this.date = date;
        this.sumUnit = sumUnit;
        this.sumMoneyBuy = sumMoneyBuy;
        this.weightToSheet = weightToSheet;
    }


}
