package com.dal.economizer.service;

import com.dal.economizer.model.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    List<User> getUsers();

    boolean validateUser(String email, String password);

    void updateUser(User user);
}
