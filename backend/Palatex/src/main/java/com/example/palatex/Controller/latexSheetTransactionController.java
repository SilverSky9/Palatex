package com.example.palatex.Controller;


import com.example.palatex.POJO.LatexSheetTransaction;
import com.example.palatex.POJO.Transaction;
import com.example.palatex.Service.latexSheetTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sheetTransaction")
public class latexSheetTransactionController {
    @Autowired
    private latexSheetTransactionService latexSheetTransactionService;

    //Get All LatexSheet transaction in mongoDB
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllSheetTransaction(){
        List<LatexSheetTransaction> latexSheetTransaction = latexSheetTransactionService.getAllLatexSheetTransactionService();
        return  ResponseEntity.ok(latexSheetTransaction);
    }


    //Save LatexSheet transaction to mongoDB
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addLatexSheetTransactionService(@RequestBody LatexSheetTransaction latexSheetTransaction){
        latexSheetTransactionService.save(latexSheetTransaction);
        return ResponseEntity.ok("Save latex sheet transaction");

    }
}
