package com.houses.controllers;

import com.houses.common.model.User;
import com.houses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
