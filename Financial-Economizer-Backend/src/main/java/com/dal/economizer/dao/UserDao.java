package com.dal.economizer.dao;

import com.dal.economizer.model.User;

import java.util.List;

public interface UserDao {

    void registerUser(User user);

    List<User> getUsers();

    boolean validateUser(String email, String password);
}
