package com.example.palatex.POJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter

@Data
@Document("latex_sheet")
public class LatexSheet implements Serializable {

    @Id
    private String _id;
//    private int latex_sheet_id;
    private Date date;
    private double unit;

    public LatexSheet(){}

    public LatexSheet(String _id, Date date,double unit){
        this._id = _id;
//        this.latex_sheet_id = latex_sheet_id;
        this.date = date;
        this.unit = unit;


    }


}
