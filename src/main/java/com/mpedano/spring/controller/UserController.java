package com.mpedano.spring.controller;

import com.mpedano.spring.messageexample.SetterMessage;
import com.mpedano.spring.model.Student;
import com.mpedano.spring.model.User;
import com.mpedano.spring.service.StudentService;
import com.mpedano.spring.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SetterMessage setterMessage;

    private Logger logger = LogManager.getLogger(this.getClass());

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("user/user_page");

        List<User> list = userService.listAllUsers();
        model.addObject("listUser", list);

        List<Student> listStudent = studentService.listAllStudents();
        model.addObject("listStudent", listStudent);

        logger.info(setterMessage.getMessage());
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView model = new ModelAndView("user/user_form");

        User user = new User();
        model.addObject("userForm", user);

        return model;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView addStudent() {
        ModelAndView model = new ModelAndView("student/student_form");

        Student student = new Student();
        model.addObject("studentForm", student);

        return model;
    }

    @RequestMapping(value = "/update/{userId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("userId") int userId) {
        ModelAndView model = new ModelAndView("user/user_form");

        User user = userService.findUserById(userId);
        model.addObject("userForm", user);

        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("userForm") User user) {
        if (user != null && user.getUserId() != null) {
            //update
            userService.updateUser(user);
        } else {
            //add new
            userService.addUser(user);
        }

        return new ModelAndView("redirect:/user/list");
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);

        return new ModelAndView("redirect:/user/list");
    }
}

