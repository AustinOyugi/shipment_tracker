package com.myshipment.tracker.services;

import com.myshipment.tracker.models.User;
import com.myshipment.tracker.payloads.LoginRequest;
import com.myshipment.tracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Austin Oyugi
 * @date 10/13/2020
 * @email austinoyugi@gmail.com
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> processLogin(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByUserNameOrEmail(loginRequest.getUserNameOrEmail(),
                loginRequest.getUserNameOrEmail());
        if (!optionalUser.isPresent())
            return ResponseEntity.badRequest().body("User Not found");

        if (!optionalUser.get().getPassword().equals(loginRequest.getPassword()))
            return ResponseEntity.badRequest().body("Wrong Password");

        return ResponseEntity.ok(optionalUser.get());
    }
}
