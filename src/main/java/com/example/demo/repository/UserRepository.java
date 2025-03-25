package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.example.demo.usermodel.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   // @Query("{email :?0}")
    //User findByEmail(String email);

    // Find a user by email
    User findByEmail(String email);

    // Check if an email already exists
    boolean existsByEmail(String email);
}
