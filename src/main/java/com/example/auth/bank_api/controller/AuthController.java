package com.example.auth.bank_api.controller;

import com.example.auth.bank_api.dtos.UserRecordDTO;
import com.example.auth.bank_api.models.UserModel;
import com.example.auth.bank_api.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity ok() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRecordDTO userRecordDTO) {
        // <TO-DO> Create service for this operation!
        // <TO-DO> Register user with hash password!
        var newUser = new UserModel();
        newUser.setLogin(userRecordDTO.login());
        newUser.setPassword(userRecordDTO.password());
        userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.OK).body("Register user successfully!");
    }

    // <TO-DO> Login
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody @Valid UserRecordDTO userRecordDTO) {
//
}
