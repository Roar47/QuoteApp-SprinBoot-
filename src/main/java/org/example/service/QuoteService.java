package org.example.service;

import org.example.beans.Quote;
import org.example.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;

@Service
public class QuoteService {

    private int quotesTableSize;
    @Autowired
    private QuoteRepository quoteRepository;
    QuoteService(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
        quotesTableSize = this.quoteRepository.getQuotesTableSize();
    }
    public Quote getQuote(Map<String,String> params){
        if(params.isEmpty()){
            return getRandomQuote();
        }
        if(params.containsKey("user")){
            return getQuoteforUser(params.get("user"));
        }
        return getQuoteBasedOnParams(params);
    }

    private Quote getQuoteBasedOnParams(Map <String,String> params) {
        if(params.containsKey("browser") && params.get("browser").equals("chrome")){
            return this.quoteRepository.getQuotebyCategory("English");
        }
        else if(params.containsKey("country") && params.get("country").equals("US")){
            return this.quoteRepository.getQuotebyAuthor("Shakespeare");
        }
        else {
            return getRandomQuote();
        }
    }

    private Quote getRandomQuote(){
        int randID = new Random().nextInt(quotesTableSize);
        return quoteRepository.getQuotebyID(randID);
    }

    private Quote getQuoteforUser(String user){
        LocalDate today = LocalDate.now();
        String seedStr = user + today.toString();
        int seedValue = seedStr.hashCode();

        Random random = new Random(seedValue);
        int userId = random.nextInt() % quotesTableSize;
        return quoteRepository.getQuotebyID(userId);
    }
}
