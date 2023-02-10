package com.dal.economizer.controller;

import com.dal.economizer.model.User;
import com.dal.economizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/loginValidate")
    public boolean loginValidate(@RequestBody Map<String, String> loginRequest) {

        System.out.println(userService.validateUser(loginRequest.get("email"), loginRequest.get("password"))==true? "User found" : "User Not Found");
        return userService.validateUser(loginRequest.get("email"), loginRequest.get("password"));
    }



}
