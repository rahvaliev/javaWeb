package com.example.restclientapi;

import com.example.restclientapi.model.dto.BookDTO;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClientBookDemo implements CommandLineRunner {
    private static final String API_URI="http://localhost:8080/api/books";
    private static final Logger LOGGER= LoggerFactory.getLogger(RestClientBookDemo.API_URI);
    private final RestTemplate restTemplate;

    public RestClientBookDemo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<BookDTO[]> allBooksResponse=restTemplate.getForEntity(API_URI,BookDTO[].class);

        if(allBooksResponse.hasBody()){
            for (BookDTO bookDTO : allBooksResponse.getBody()) {
                LOGGER.info("Retrieved a book: {}",bookDTO);
            }

        }


    }
}
