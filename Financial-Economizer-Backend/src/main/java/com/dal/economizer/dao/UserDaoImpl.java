package com.dal.economizer.dao;

import com.dal.economizer.model.User;
import com.dal.economizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean validateUser(String email, String password) {
        return userRepository.findUserByEmailPassword(email,password)!= null ? true : false;
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
