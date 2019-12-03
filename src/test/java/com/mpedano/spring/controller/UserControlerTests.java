package com.mpedano.spring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

public class UserControlerTests {

    @Test
    public void testHandleRequestView() throws Exception {
        UserController controller = new UserController();
        ModelAndView modelAndView = controller.list();
        assertEquals("user/user_page", modelAndView.getViewName());
    }
}
