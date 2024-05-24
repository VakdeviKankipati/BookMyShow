package com.vakya.bookmyshow.services;

import com.vakya.bookmyshow.repository.MovieRepository;
import com.vakya.bookmyshow.repository.ShowRepository;
import org.springframework.stereotype.Service;
import com.vakya.bookmyshow.dtos.RequestDto.MovieEntryDto;
import com.vakya.bookmyshow.exception.MovieAlreadyPresentWithSameNameAndLanguage;
import com.vakya.bookmyshow.models.Movie;
import com.vakya.bookmyshow.transformers.MovieTransformer;

import java.util.Optional;

@Service("movieService")
public class MovieService {


    MovieRepository  movieRepository;

    ShowRepository showRepository;

    public String addMovie(MovieEntryDto movieEntryDto) throws MovieAlreadyPresentWithSameNameAndLanguage {


        Optional<Movie> movieOptional= Optional.ofNullable(movieRepository.findByMovieName(movieEntryDto.getMovieName()));
        if(movieOptional.isPresent()){
            throw new MovieAlreadyPresentWithSameNameAndLanguage("Movie is Already present by same name");
        }

        Movie movie = MovieTransformer.convertDtoToEntity(movieEntryDto);
        movieRepository.save(movie);
        return "Movie added successfully";

    }


}
