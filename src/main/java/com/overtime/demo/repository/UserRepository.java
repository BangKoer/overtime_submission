package com.overtime.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overtime.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);
}
