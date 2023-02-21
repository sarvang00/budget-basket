package com.dal.PFE.controller;

import com.dal.PFE.model.User;
import com.dal.PFE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
     private UserService userService;

    @PostMapping("/registerUser")
    public void registerUser(@RequestBody User user){
        System.out.println(user.getName() +" , "+user.getEmail());
        userService.registerUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();

    }



}
