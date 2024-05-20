package com.vakya.bookmyshow.dtos.RequestDto;

import com.vakya.bookmyshow.enums.Genre;
import com.vakya.bookmyshow.enums.Language;
import lombok.Data;

import java.sql.Date;

@Data
public class MovieEntryDto {
    private String movieName;
    private double duration;
    private double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}
