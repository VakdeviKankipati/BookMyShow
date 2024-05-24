package com.vakya.bookmyshow.controllers;

import com.vakya.bookmyshow.dtos.RequestDto.MovieEntryDto;
import com.vakya.bookmyshow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    private RestTemplate restTemplate;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){

        try {
            String result= movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
