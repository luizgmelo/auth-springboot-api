package com.example.auth.bank_api.controller;

import com.example.auth.bank_api.dtos.UserRecordDTO;
import com.example.auth.bank_api.models.UserModel;
import com.example.auth.bank_api.repositories.UserRepository;
import com.example.auth.bank_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity ok() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRecordDTO userRecordDTO) {
        userService.register(userRecordDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Register user successfully!");
    }

    // <TO-DO> Login
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody @Valid UserRecordDTO userRecordDTO) {
//
}
