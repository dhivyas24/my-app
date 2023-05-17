package com.example.demo.cotroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.userModel;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/user")
public class User{
    
        
        private final UserService userService;
    
        public User(UserService userService) {
            this.userService = userService;
        }
    
        @PostMapping
        public ResponseEntity<userModel> addUser(@RequestBody userModel user) {
            userModel createdUser = userService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<userModel> getUser(@PathVariable Long id) {
            userModel user = userService.getUserById(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    
        @PutMapping("/{id}")
        public ResponseEntity<userModel> updateUser(@PathVariable Long id, @RequestBody userModel user) {
            userModel updatedUser = userService.updateUser(id, user);
            if (updatedUser != null) {
                return ResponseEntity.ok(updatedUser);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
            boolean deleted = userService.deleteUser(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        public void setId(long nextId) {
        }
    }
    