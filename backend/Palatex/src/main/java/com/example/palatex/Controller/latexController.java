package com.example.palatex.Controller;

import com.example.palatex.POJO.Latex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.palatex.Service.latexService;

import java.util.List;

@RestController
@RequestMapping(value = "/latex")
public class latexController {
    @Autowired
    private latexService latexService;

    //Get all latex record in mongoDB
    @RequestMapping(value = "/all",  method = RequestMethod.GET)
    public ResponseEntity<?> getAllLatexRecord(){
        List<Latex> ans = latexService.getAllLatexService();
        return  ResponseEntity.ok(ans);
    }
    //Get latex record by ID in mongoDB
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getLatexRecord(@PathVariable String id ){
        Latex latex = latexService.getLatexByIdService(id);
        return ResponseEntity.ok(latex);
    }
    //Save latex record to mongoDB
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> saveLatexRecord(Latex l){
        latexService.addLatexRecordService(l);
        return ResponseEntity.ok("Save latex record");
    }

    //TODO
    //Can get latex record by date!
}
