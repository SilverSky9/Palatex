package com.example.palatex.Service;

import com.example.palatex.POJO.Latex;
import com.example.palatex.Repository.latexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class latexService {

    @Autowired
    latexRepository latexRepository;

    public latexService(latexRepository latexRepository){
        this.latexRepository = latexRepository;
    }
    //Get all latex record in mongoDB
    public List<Latex> getAllLatexService(){
        return latexRepository.findAll();
    }
    //Get latex record by id in mongoDB
    public Latex getLatexByIdService(String id){
        return latexRepository.findAllById(id);
    }
    //Save transaction to mongoDB
    public Latex addLatexRecordService(Latex l){
        return latexRepository.save(l);
    }

    //Delete latex record by ID in mongoDB
    public boolean deleteLatexRecordService(String id){
        try {
            latexRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
