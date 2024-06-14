package com.example.auth.bank_api.services;

import com.example.auth.bank_api.dtos.RegisterRecordDTO;
import com.example.auth.bank_api.dtos.UserRecordDTO;
import com.example.auth.bank_api.models.UserModel;
import com.example.auth.bank_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    public String register(RegisterRecordDTO registerRecordDTO) {
        if (this.userRepository.findByLogin(registerRecordDTO.login()) != null) throw new RuntimeException();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerRecordDTO.password());

        var newUser = new UserModel();
        newUser.setLogin(registerRecordDTO.login());
        newUser.setPassword(encryptedPassword);
        newUser.setRole(registerRecordDTO.role());
        userRepository.save(newUser);
        return "Register user successfully!";
    }

    public String login(UserRecordDTO userRecordDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(userRecordDTO.login(), userRecordDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        return token;
    }

}
