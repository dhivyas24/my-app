package com.example.demo.service;

import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.userModel;

@Service
public class UserService {
    private Map<Long, userModel> users = new HashMap<>();
    private long nextId = 1;

    public userModel addUser(userModel user) {
        user.setId(nextId);
        users.put(nextId, user);
        nextId++;
        return user;
    }

    public userModel getUserById(Long id) {
        return users.get(id);
    }

    public userModel updateUser(Long id, userModel user2) {
        userModel user = users.get(id);
        if (user != null) {
            user2.setId(id);
            users.put(id, user2);
            return user2;
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        userModel user = users.remove(id);
        return user != null;
    }
}
