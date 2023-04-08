package com.dal.PFE.repository;
import com.dal.PFE.model.User;
import com.dal.PFE.model.UserAddress;
import com.dal.PFE.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@SpringBootTest
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindUserByEmailAndPassword() {

        Date date = new Date();
        List<UserAddress> userAddresses = new ArrayList<UserAddress>();
        User user = new User(2, "Developer", "Spring", "test@example.com", "Dev@1234", "987654321", date,date,userAddresses);

        when(userRepository.findUserByEmailPassword("test@example.com", "Dev@1234")).thenReturn(user);

        User result = userRepository.findUserByEmailPassword("test@example.com", "Dev@1234");
        assertEquals(user, result);
    }

    @Test
    public void testFindUserByEmail() {
        Date date = new Date();
        List<UserAddress> userAddresses = new ArrayList<UserAddress>();
        User user = new User(2, "Developer", "Spring", "test@example.com", "Dev@1234", "987654321", date,date,userAddresses);
        when(userRepository.findUserByEmail("test@example.com")).thenReturn(user);

        User result = userRepository.findUserByEmail("test@example.com");
        assertEquals(user, result);
    }

    @Test
    public void testFindUserByEmailNotFound() {
        when(userRepository.findUserByEmail(anyString())).thenReturn(null);

        User result = userRepository.findUserByEmail("test@example.com");
        assertEquals(null, result);
    }

}
