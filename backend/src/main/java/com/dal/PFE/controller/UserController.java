package com.dal.PFE.controller;

import com.dal.PFE.model.User;
import com.dal.PFE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public boolean registerUser(@RequestBody User user){
        if (userService.alreadyExist(user)){
            return false;
        }else {
            System.out.println(user.getFirstName() + " , " + user.getEmail());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userService.registerUser(user);
            return true;
        }

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
    public User loginValidate(@RequestBody Map<String, String> loginRequest) {

        User user = userService.findUserByEmail(loginRequest.get("email"));

        if (user != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = user.getPassword();

            if(passwordEncoder.matches(loginRequest.get("password"), encodedPassword)){
                System.out.println("Credentials match ");
                return user;
            }
        }
        System.out.println("Credentials did not match ");
        return null;
    }


}
