package com.dal.PFE.model;

import org.apache.catalina.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UserTest {


     User testUser = new User();

     private final PrintStream standardOut = System.out;
     private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

     @BeforeEach
     public void setUp() {
          System.setOut(new PrintStream(outputStreamCaptor));
     }

     @Test



}
