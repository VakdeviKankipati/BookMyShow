package com.vakya.bookmyshow.repository;

import com.vakya.bookmyshow.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,Integer> {
    Theater findByLocation(String location);
}
