package com.dal.PFE.dao;

import com.dal.PFE.model.User;

import java.util.List;

public interface UserDao {

    void registerUser(User user);

    List<User> getUsers();

    User validateUser(String email, String password);


    void updateUser(User user);

    User findUserByEmail(String email);
}
