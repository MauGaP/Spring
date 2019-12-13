package com.mpedano.spring.service;

import com.mpedano.spring.model.User;
import com.mpedano.spring.utils.TestUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@RunWith
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class TestUserService {

    @Autowired
    UserService userService;

    @Test
    public void testUserCreation() {
        User user = TestUtils.createUser();
        userService.addUser(user);

        List<User> users = userService.listAllUsers();
        assertNotNull(users);
        assertEquals(users.size(), 1);
        assertEquals(users.get(0).getFirstName(), user.getFirstName());
        assertEquals(users.get(0).getLastName(), user.getLastName());
        assertEquals(users.get(0).getAddress(), user.getAddress());
    }
}
