package com.dal.economizer.service;

import com.dal.economizer.dao.UserDao;
import com.dal.economizer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void registerUser(User user) {

        userDao.registerUser(user);

    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public boolean validateUser(String email, String password) {
        return userDao.validateUser(email, password);
    }
}
