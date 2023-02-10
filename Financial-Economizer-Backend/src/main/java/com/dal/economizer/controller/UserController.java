package com.dal.economizer.controller;

import com.dal.economizer.model.User;
import com.dal.economizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void saveUser(User user){
        userService.saveUser(user);
    }


}
