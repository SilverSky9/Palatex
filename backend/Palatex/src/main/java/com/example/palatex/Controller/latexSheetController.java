package com.example.palatex.Controller;
import com.example.palatex.POJO.LatexSheet;
import com.example.palatex.POJO.Transaction;
import com.example.palatex.Service.latexSheetService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate; // import the LocalDate class
import java.text.ParseException;
import java.util.ArrayList;



@RestController
@RequestMapping(value = "/sheet")
public class latexSheetController {
    @Autowired
    private latexSheetService latexSheetService;

    @Autowired
    private AnalysisController analysisController;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //Get all latex sheet record in mongoDB

    //Get latex sheet record by ID in mongoDB
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getLatexSheetRecord(@PathVariable String id ){
        LatexSheet sheet = latexSheetService.findAllByIdService(id);
        return ResponseEntity.ok(sheet);
    }
    //Save latex sheet record to mongoDB
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public  ResponseEntity<?> saveLatexSheetRecord(@RequestBody LatexSheet latexSheet){
        latexSheetService.saveLatexRecordService(latexSheet);
        return ResponseEntity.ok("Save latex sheet record");
    }
    //Count all latex sheet in mongoDB
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseEntity<?> countAllLatexSheet(){
        return ResponseEntity.ok(latexSheetService.countAllLatexSheetService());
    }
    //Delete latex sheet record in mongoDB
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delLatexSheet(@PathVariable String id){
        latexSheetService.deleteLatexSheetRecordService(id);
        return ResponseEntity.ok("Delete latex record!");
    }



    //SumAllUnit of Latex
    @RequestMapping(value = "/sumunits", method = RequestMethod.GET)
    public LatexSheet getSumUnits() {
        ArrayList<Transaction> transactions = new ArrayList<>();




        transactions = (ArrayList<Transaction>) analysisController.getSumMoney();

        LocalDate dateToday = LocalDate.now(); // Create a date object

        double sumUnit = 0;
        double sumMoneyBuy = 0;
        double weightToSheet = 0;
        for (Transaction transaction: transactions
             ) {


            if (dateToday.compareTo(transaction.getDate()) == 0) {
               sumUnit += transaction.getUnit();
               sumMoneyBuy += transaction.getTotal_price();
               System.out.println((transaction.getDate()) + " , " + dateToday);
            }
        }
        weightToSheet = sumUnit * 0.35;

        System.out.println(sumUnit + "  " + sumMoneyBuy + "  " + weightToSheet);

        LatexSheet latexSheet = new LatexSheet(dateToday, sumUnit,  sumMoneyBuy,  weightToSheet);
        return latexSheet;
    }
}


