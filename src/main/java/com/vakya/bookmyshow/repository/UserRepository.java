package com.vakya.bookmyshow.repository;

import com.vakya.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from users where age >= :value",nativeQuery=true)
    List<User> findUserWithAgeGreater(Integer value);
}
