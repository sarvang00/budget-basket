package com.dal.PFE.dao;

import com.dal.PFE.model.User;

import java.util.List;

public interface UserDao {

    void registerUser(User user);

    List<User> getUsers();
}
