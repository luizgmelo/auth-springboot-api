package com.example.auth.bank_api.services;

import com.example.auth.bank_api.dtos.UserRecordDTO;
import com.example.auth.bank_api.models.UserModel;
import com.example.auth.bank_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel register(UserRecordDTO userRecordDTO) {
        // <TO-DO> Register user with hash password!
        var newUser = new UserModel();
        newUser.setLogin(userRecordDTO.login());
        newUser.setPassword(userRecordDTO.password());
        userRepository.save(newUser);
        return newUser;
    }

}
