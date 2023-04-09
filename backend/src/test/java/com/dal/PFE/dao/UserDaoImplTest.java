package com.dal.PFE.dao;

import com.dal.PFE.FinancialEconomizerBackendApplication;
import com.dal.PFE.model.User;
import com.dal.PFE.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FinancialEconomizerBackendApplication.class)

public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setEmail("user1@gmail.com");
        user.setPassword("abc");
        userDao.registerUser(user);

        List<User> users = userRepository.findAll();
        assertEquals(1, users.size());

        User savedUser = users.get(0);
        assertEquals("user1@gmail.com", savedUser.getEmail());
        assertEquals("abc", savedUser.getPassword());
    }

    @Test
    public void testGetUsers() {
        User user1 = new User();
        user1.setEmail("user1@gmail.com");
        user1.setPassword("abc");
        userDao.registerUser(user1);

        User user2 = new User();
        user2.setEmail("user2@gmail.com");
        user2.setPassword("def");
        userDao.registerUser(user2);

        List<User> users = userDao.getUsers();
        assertEquals(2, users.size());

        User savedUser1 = users.get(0);
        assertEquals("user1@gmail.com", savedUser1.getEmail());
        assertEquals("abc", savedUser1.getPassword());

        User savedUser2 = users.get(1);
        assertEquals("user2@gmail.com", savedUser2.getEmail());
        assertEquals("def", savedUser2.getPassword());
    }

    @Test
    public void testValidateUser() {
        User user = new User();
        user.setEmail("user1@gmail.com");
        user.setPassword("abc");
        userDao.registerUser(user);

        User foundUser = userDao.validateUser("user1@gmail.com", "abc");
        assertNotNull(foundUser);
        assertEquals("user1@gmail.com", foundUser.getEmail());
        assertEquals("abc", foundUser.getPassword());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setEmail("user1@gmail.com");
        user.setPassword("abc");
        userDao.registerUser(user);

        user.setPassword("abcdef");
        userDao.updateUser(user);

        User updatedUser = userRepository.findById(user.getUserId()).orElse(null);
        assertNotNull(updatedUser);
        assertEquals("user1@gmail.com", updatedUser.getEmail());
        assertEquals("abcdef", updatedUser.getPassword());
    }

    @Test
    public void testFindUserByEmail() {
        User user = new User();
        user.setEmail("user1@gmail.com");
        user.setPassword("abc");
        userDao.registerUser(user);

        User foundUser = userDao.findUserByEmail("user1@gmail.com");
        assertNotNull(foundUser);
        assertEquals("user1@gmail.com", foundUser.getEmail());
        assertEquals("abc", foundUser.getPassword());
    }

   /* @Test
    public void testAlreadyExist() {
        User user = new User();
        user.setEmail("user1@gmail.com");
        user.setPassword("abc");
        userDao.registerUser(user);

        User existingUser = new User();
        existingUser.setEmail("user1@gmail.com");
        existingUser.setPassword("abc");

        boolean alreadyExists = userDao.alreadyExist(existingUser);
        assertTrue(alreadyExists);

        User newUniqueUser = new User();
        newUniqueUser.setEmail("uniqueuser@gmail.com");
        newUniqueUser.setPassword("xyz");

        boolean doesNotExist = userDao.alreadyExist(newUniqueUser);
        assertFalse(doesNotExist);
    }*/

}
