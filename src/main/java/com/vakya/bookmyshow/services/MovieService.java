package com.vakya.bookmyshow.services;

import com.vakya.bookmyshow.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieService {

    @Autowired
    MovieRepository  movieRepository;


}
