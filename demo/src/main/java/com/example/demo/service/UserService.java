package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel;
import com.example.demo.repo.UserRepo;


@Service
public class UserService {
    private UserRepo userRepository;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public userModel addUser(userModel user) {
        return userRepository.save(user);
    }

    public userModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public userModel updateUser(Long id, userModel user2) {
        userModel user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user2.setId(id);
            return userRepository.save(user2);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
