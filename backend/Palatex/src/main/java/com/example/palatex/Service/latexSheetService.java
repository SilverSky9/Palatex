package com.example.palatex.Service;

import com.example.palatex.POJO.LatexSheet;
import com.example.palatex.Repository.latexSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class latexSheetService {
    @Autowired
    private latexSheetRepository latexSheetRepository;

    public latexSheetService(latexSheetRepository latexSheetRepository){
        this.latexSheetRepository = latexSheetRepository;
    }
    //Get all latex sheet in mongoDB
    public List<LatexSheet> getAllLatexSheetService(){
        return latexSheetRepository.findAll();
    }
    //Get latex sheet by id in mongoDB
    public LatexSheet findAllByIdService(String id){
        return latexSheetRepository.findAllById(id);
    }
    //Save latex sheet to mongoDB
    public LatexSheet saveLatexRecordService(LatexSheet l){
        return latexSheetRepository.save(l);
    }
    //Delete latex sheet by ID in mongoDB
    public boolean deleteLatexSheetRecordService(String id){
        try {
            latexSheetRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
