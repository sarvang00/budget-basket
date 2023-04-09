
package com.dal.PFE.controller;

import com.dal.PFE.model.User;
import com.dal.PFE.model.UserAddress;
import com.dal.PFE.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void registerUserTest() {
        Date date = new Date();
        List<UserAddress> userAddresses = new ArrayList<UserAddress>();
        User user = new User(2, "Developer", "Spring", "dev@gmail.com", "Dev@1234", "987654321", date,date,userAddresses);


        when(userService.alreadyExist(user)).thenReturn(false);

        boolean result = userController.registerNewUser(user);
        assertTrue(result);
    }

    @Test
    void updateUserTest() {
        Date date = new Date();
        List<UserAddress> userAddresses = new ArrayList<UserAddress>();
        User user = new User(2, "Developer", "Spring", "dev@gmail.com", "Dev@1234", "987654321", date,date,userAddresses);
        userController.updateUser(user);
        verify(userService, times(1)).updateUser(user);
    }

    @Test
    void getUsersTest() {
        List<User> userList = new ArrayList<>();
        Date date = new Date();
        List<UserAddress> userAddresses = new ArrayList<UserAddress>();
        User user1 = new User(2, "Developer", "Spring", "dev@gmail.com", "Dev@1234", "987654321", date,date,userAddresses);
        User user2 = new User(3, "Developer1", "Spring1", "dev@gmail1.com", "Dev@12341", "987654321", date,date,userAddresses);

        userList.add(user1);
        userList.add(user2);

        when(userService.getUsers()).thenReturn(userList);

        List<User> result = userController.getUsers();

        assertEquals(2, result.size());
        assertEquals(userList, result);
    }

    @Test
    void loginValidateTest() {
        Date date = new Date();
        List<UserAddress> userAddresses = new ArrayList<UserAddress>();
        User user = new User(2, "Developer", "Spring", "dev@gmail.com", "Dev@1234", "987654321", date,date,userAddresses);

        String email = "johndoe@example.com";
        String password = "password";

        when(userService.findUserByEmail(email)).thenReturn(user);

//        assertNotNull(userController.loginValidate(Map.of("email", email, "password", password)));

        password = "wrongpassword";
        assertNull(userController.loginValidate(Map.of("email", email, "password", password)));
    }
}