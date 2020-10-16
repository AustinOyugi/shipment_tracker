package com.myshipment.tracker.controllers;

import com.myshipment.tracker.models.User;
import com.myshipment.tracker.payloads.LoginRequest;
import com.myshipment.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Austin Oyugi
 * @date 10/13/2020
 * @email austinoyugi@gmail.com
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    private ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return userService.processLogin(loginRequest);
    }

    @PostMapping("register")
    private ResponseEntity<?> register(@RequestBody User user){
        return userService.register(user);
    }
}
