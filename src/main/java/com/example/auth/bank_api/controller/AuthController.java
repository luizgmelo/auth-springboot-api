package com.example.auth.bank_api.controller;

import com.example.auth.bank_api.dtos.RegisterRecordDTO;
import com.example.auth.bank_api.dtos.UserRecordDTO;
import com.example.auth.bank_api.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthService userService;
    @Autowired
    private AuthService authService;

    @GetMapping
    public ResponseEntity ok() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegisterRecordDTO registerRecordDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.register(registerRecordDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody @Valid UserRecordDTO userRecordDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(userRecordDTO));
    }
}
