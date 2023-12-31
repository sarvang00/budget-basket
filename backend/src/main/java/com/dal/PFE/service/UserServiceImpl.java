package com.dal.PFE.service;

import com.dal.PFE.dao.UserDao;
import com.dal.PFE.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements com.dal.PFE.service.UserService {


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
    public User validateUser(String email, String password) {
        return userDao.validateUser(email, password);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    @Transactional
    public boolean alreadyExist(User user) {
        return userDao.alreadyExist(user);
    }
}
