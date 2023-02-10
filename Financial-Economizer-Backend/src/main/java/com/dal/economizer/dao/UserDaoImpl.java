package com.dal.economizer.dao;

import com.dal.economizer.model.User;
import com.dal.economizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }
}
