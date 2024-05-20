package com.vakya.bookmyshow.repository;

import com.vakya.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findByMovieName(String name);

}
