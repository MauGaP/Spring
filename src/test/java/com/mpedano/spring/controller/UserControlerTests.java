package com.mpedano.spring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mpedano.spring.model.User;
import com.mpedano.spring.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

public class UserControlerTests {
    private List<User> users;
    private User user;
    private UserService userService;
    private UserController userController;

    @BeforeEach
    public void initUser(){
        users = new ArrayList<>();
        user = new User();
        user.setAddress("Mi direccion");
        user.setFirstName("FirstName");
        user.setLastName("LastName");

        users.add(user);
        userService = mock(UserService.class);
        when(userService.listAllUsers()).thenReturn(users);

        userController = mock(UserController.class);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/user_page");
        modelAndView.addObject("listUser", users);

        when(userController.list()).thenReturn(modelAndView);

        ReflectionTestUtils.setField(userController,"userService", userService);
    }


    @Test
    public void testHandleRequestView() throws Exception {

        assertEquals("user/user_page", userController.list().getViewName());
    }

    @Test
    public void testList() throws Exception {

        List<User> modelUsers = (ArrayList<User>) userController.list().getModel().get("listUser");
        assertEquals(1, modelUsers.size());
    }
}
