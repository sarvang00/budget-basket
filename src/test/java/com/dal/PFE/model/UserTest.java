package com.dal.PFE.model;

import org.apache.catalina.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UserTest {


     UserTest testUser = new UserTest();

     private final PrintStream standardOut = System.out;
     private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

     @BeforeEach
     public void setUp() {
          System.setOut(new PrintStream(outputStreamCaptor));
     }

     @Test
     @Test
     public void canHandleSingleUser() {
          
          int userId = 1;
          String firstName = "dev";
          String lastName = "k";
          String email = "dev@budgetb.com";
          String password "abc123";
          String phoneNumber = '987654321';
          Date createdAt = '12/03/2023';
          Date updatedAt = '12/03/2023';
          List<UserAddress> userAddresses;
          userAddresses.add("young street");
          
          User user1 = new User(userId,firstName,lastName,email,password,phoneNumber,createdAt,updatedAt,userAddresses);
     }


     public void canHandleDuplicateUser(){

          testUser.canHandleSingleUser();
          int userId = 1;
          String firstName = "dev";
          String lastName = "k";
          String email = "dev@budgetb.com";
          String password "abc123";
          String phoneNumber = '987654321';
          Date createdAt = '12/03/2023';
          Date updatedAt = '12/03/2023';
          List<UserAddress> userAddresses;
          userAddresses.add("young street");

          User user2 = new User(userId,firstName,lastName,email,password,phoneNumber,createdAt,updatedAt,userAddresses);
          
     }

}
