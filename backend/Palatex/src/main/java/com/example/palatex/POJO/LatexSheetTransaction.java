package com.example.palatex.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter

@Data
@Document("latex_sheet_transaction")
public class LatexSheetTransaction {

    @Id
    private String _id;
    private Date dateTime;
    private double stockSheet;
    private  double profit;


    public LatexSheetTransaction(){}

    public LatexSheetTransaction(Date dateTime,double stockSheet, double profit){


        this.dateTime = dateTime;
        this.stockSheet = stockSheet;
        this.profit = profit;
    }
}
