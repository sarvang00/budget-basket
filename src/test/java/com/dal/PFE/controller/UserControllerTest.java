package com.dal.PFE.controller;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;

public class UserControllerTest {

    @Test
    UserControllerTest test = new UserControllerTest;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    

    void name() {
    }
}
