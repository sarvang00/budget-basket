package com.dal.economizer.service;

import com.dal.economizer.model.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    List<User> getUsers();
}
