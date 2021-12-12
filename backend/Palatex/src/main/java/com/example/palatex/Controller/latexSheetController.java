package com.example.palatex.Controller;

import com.example.palatex.POJO.LatexSheet;
import com.example.palatex.Service.latexSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sheet")
public class latexSheetController {
    @Autowired
    private latexSheetService latexSheetService;
    //Get all latex sheet record in mongoDB
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllLatexSheet(){
        List<LatexSheet> ans = latexSheetService.getAllLatexSheetService();

        return ResponseEntity.ok(ans);
    }
    //Get latex sheet record by ID in mongoDB
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getLatexSheetRecord(@PathVariable String id ){
        LatexSheet sheet = latexSheetService.findAllByIdService(id);
        return ResponseEntity.ok(sheet);
    }
    //Save latex sheet record to mongoDB
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public  ResponseEntity<?> saveLatexSheetRecord(@RequestBody LatexSheet latexSheet){
        latexSheetService.saveLatexRecord(latexSheet);
        return ResponseEntity.ok("Save latex sheet record");
    }
}
