package com.example.simpleproject.dao;

import com.example.simpleproject.model.User;
import com.example.simpleproject.model.UsersTwo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UsersTwo, Long> {
    Optional<UsersTwo> findByEmail(String email);
}
