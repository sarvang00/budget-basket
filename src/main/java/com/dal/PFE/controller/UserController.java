package com.dal.PFE.controller;

import com.dal.PFE.model.User;
import com.dal.PFE.service.UserService;
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
        System.out.println(user.getFirstName() +" , "+user.getEmail());
        userService.registerUser(user);
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user){
        System.out.println(user.getFirstName() +" , "+user.getEmail() + " - updated");
        userService.updateUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();

    }

    @PostMapping("/loginValidate")
    public boolean loginValidate(@RequestBody Map<String, String> loginRequest) {

        System.out.println(userService.validateUser(loginRequest.get("email"), loginRequest.get("password"))==true? loginRequest.get("email")+" - User found" : loginRequest.get("email")+ " - User Not Found");
        return userService.validateUser(loginRequest.get("email"), loginRequest.get("password"));
    }


}
