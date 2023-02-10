package com.dal.economizer.controller;

import com.dal.economizer.model.User;
import com.dal.economizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registerUser")
    public void registerUser(User user){
        userService.registerUser(user);
    }




}
