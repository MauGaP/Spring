package com.mpedano.spring.utils;

import com.mpedano.spring.model.User;

public class TestUtils {

    public static User createUser() {
        User newUser = new User();
        newUser.setFirstName("Pepe");
        newUser.setLastName("Test");
        newUser.setAddress("addressTest");

        return newUser;
    }
}
