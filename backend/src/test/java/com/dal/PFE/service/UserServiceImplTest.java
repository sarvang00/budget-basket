package com.dal.PFE.service;

import com.dal.PFE.dao.UserDao;
import com.dal.PFE.model.User;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testRegisterUser() throws Exception {
        User user = new User();
        userService.registerUser(user);
        verify(userDao, times(1)).registerUser(user);
    }

    @Test
    public void testGetUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        when(userDao.getUsers()).thenReturn(userList);
        List<User> result = userService.getUsers();
        assertEquals(userList, result);
    }

    @Test
    public void testValidateUser() throws Exception {
        String email = "test@example.com";
        String password = "password";
        User user = new User();
        when(userDao.validateUser(email, password)).thenReturn(user);
        User result = userService.validateUser(email, password);
        assertEquals(user, result);
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        userService.updateUser(user);
        verify(userDao, times(1)).updateUser(user);
    }

    @Test
    public void testFindUserByEmail() throws Exception {
        String email = "test@example.com";
        User user = new User();
        when(userDao.findUserByEmail(email)).thenReturn(user);
        User result = userService.findUserByEmail(email);
        assertEquals(user, result);
    }

}
