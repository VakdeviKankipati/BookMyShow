package com.vakya.bookmyshow.models;

import com.vakya.bookmyshow.enums.Genre;
import com.vakya.bookmyshow.enums.Language;
import jakarta.persistence.*;
//import org.intellij.lang.annotations.Language;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {

    private int id;
    @Column(nullable = false)
    private String movieName;

    private double duration;

    @Column(scale = 2)
    private double rating;

    private Date releaseDate;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();
}
