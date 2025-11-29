package com.example.SpringSecurityPlayground.controller;

import com.example.SpringSecurityPlayground.model.Users;
import com.example.SpringSecurityPlayground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user){
        return service.registerUser(user);
    }

    @PostMapping("/login")
    String loginUser(@RequestBody Users user){
        String verify = service.verify(user);
        System.out.println(verify);
        return verify;
    }
}
