package com.dal.economizer.service;

import com.dal.economizer.dao.UserDao;
import com.dal.economizer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserDao userDao;

    @Override
    public void registerUser(User user) {

        userDao.registerUser(user);

    }
}
