package org.example.controller;


import org.example.beans.Quote;
import org.example.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class QuoteController {
    @Autowired
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @RequestMapping("/quote")
    public Quote getResponse(@RequestParam Map<String,String> params) {
        return quoteService.getQuote(params);
    }
    
}
