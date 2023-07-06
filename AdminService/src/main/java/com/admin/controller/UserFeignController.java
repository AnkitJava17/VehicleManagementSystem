package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.feignConfig.UserServiceConsumer;
import com.admin.model.User;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserFeignController {

    @Autowired
    UserServiceConsumer userServiceConsumer;

     @GetMapping("/getAllUsers")
    public List<User> getAllUserHandler(){
            return userServiceConsumer.getAllUserHandler();
    }

    @GetMapping("/{username}")
    public User getByUsernameHandler(){
        
        return userServiceConsumer.getByUsernameHandler();

    }
    
}
