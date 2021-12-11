package com.example.palatex.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.palatex.Service.transactionService;

@RestController
public class transactionController {
    @Autowired
    private transactionService transactionService;



}
