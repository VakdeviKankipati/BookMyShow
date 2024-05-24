package com.vakya.bookmyshow.transformers;

import com.vakya.bookmyshow.dtos.RequestDto.MovieEntryDto;
import com.vakya.bookmyshow.models.Movie;

public class MovieTransformer {
    public static Movie convertDtoToEntity(MovieEntryDto movieEntryDto){

        Movie movie = Movie.builder().movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage())
                .rating(movieEntryDto.getRating()).releaseDate(movieEntryDto.getReleaseDate())
                .build();

        return movie;
    }
}
