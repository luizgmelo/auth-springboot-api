package com.example.auth.bank_api.services;

import com.example.auth.bank_api.models.UserModel;
import com.example.auth.bank_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }
}
