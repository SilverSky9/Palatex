package com.example.palatex.Service;

import com.example.palatex.POJO.LatexSheet;
import com.example.palatex.POJO.LatexSheetTransaction;
import com.example.palatex.POJO.Transaction;
import com.example.palatex.Repository.latexSheetTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class latexSheetTransactionService {
    @Autowired
    private latexSheetTransactionRepository latexSheetTransactionRepository;

    public latexSheetTransactionService(latexSheetTransactionRepository latexSheetTransactionRepository){
        this.latexSheetTransactionRepository = latexSheetTransactionRepository;
    }

    //Get all latexsheet Trasaction in mongoDB
    public List<LatexSheetTransaction> getAllLatexSheetTransactionService(){
        return latexSheetTransactionRepository.findAll();
    }


    //Save transaction to mongoDB
    public LatexSheetTransaction save(LatexSheetTransaction t){
        return latexSheetTransactionRepository.save(t);
    }




}
