package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.userModel;

public interface UserRepo extends JpaRepository<userModel, Long> {

  

}



