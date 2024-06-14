package com.example.auth.bank_api.controller;

import com.example.auth.bank_api.models.UserModel;
import com.example.auth.bank_api.services.AuthService;
import com.example.auth.bank_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // Only admin has permission
    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    // Users and admin has permission
    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcomeMessage() {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to Bank API");
    }

}
