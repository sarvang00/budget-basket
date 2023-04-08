package com.dal.PFE.service;

import com.dal.PFE.model.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    List<User> getUsers();

    User validateUser(String email, String password);

    void updateUser(User user);

    User findUserByEmail(String email);

    boolean alreadyExist(User user);
}
