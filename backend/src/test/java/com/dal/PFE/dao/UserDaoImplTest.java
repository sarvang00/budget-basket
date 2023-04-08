
package com.dal.PFE.dao;

import com.dal.PFE.model.User;
import com.dal.PFE.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
@SpringBootTest
class UserDaoImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDaoImpl userDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterUser() {
        User user = new User();
        userDao.registerUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetUsers() {
        List<User> userList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList);

        List<User> result = userDao.getUsers();
        assertEquals(userList, result);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testValidateUser() {
        String email = "test@example.com";
        String password = "password";
        User expectedUser = new User();
        when(userRepository.findUserByEmailPassword(email, password)).thenReturn(expectedUser);

        User result = userDao.validateUser(email, password);
        assertEquals(expectedUser, result);
        verify(userRepository, times(1)).findUserByEmailPassword(email, password);
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        userDao.updateUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testFindUserByEmail() {
        String email = "test@example.com";
        User expectedUser = new User();
        when(userRepository.findUserByEmail(email)).thenReturn(expectedUser);

        User result = userDao.findUserByEmail(email);
        assertEquals(expectedUser, result);
        verify(userRepository, times(1)).findUserByEmail(email);
    }

}
