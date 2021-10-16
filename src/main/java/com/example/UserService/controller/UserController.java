package com.example.UserService.controller;

import com.example.UserService.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user") // http://localhost:8082/user-service/user
public class UserController {

    @Autowired
    private UserRepository userRepository;

    
}
