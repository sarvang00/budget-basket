package com.dal.PFE.service;

import com.dal.PFE.dao.UserDao;
import com.dal.PFE.model.User;

import com.dal.PFE.model.UserAddress;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    public void testRegisterUserWithData() throws Exception {
        Date date = new Date();
        List<UserAddress> userAddresses = new ArrayList<UserAddress>();
        User user = new User(2, "Developer", "Spring", "dev@gmail.com", "Dev@1234", "987654321", date,date,userAddresses);
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
        Date date = new Date();
        List<UserAddress> userAddresses = new ArrayList<UserAddress>();
        User user = new User(2, "Developer", "Spring", "dev@gmail.com", "Dev@1234", "987654321", date,date,userAddresses);
        userService.updateUser(user);
        verify(userDao, times(1)).updateUser(user);
    }

    @Test
    public void testUpdateUserWithData() throws Exception {
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
