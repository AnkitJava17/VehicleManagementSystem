package com.admin.feignConfig;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.admin.model.User;

@FeignClient(name="user-service", url = "http://localhost:8085/api/v1/users")
public interface UserServiceConsumer {

    @GetMapping("/getAllUsers")
    public List<User> getAllUserHandler();

    @GetMapping("/{username}")
    public User getByUsernameHandler();
}
