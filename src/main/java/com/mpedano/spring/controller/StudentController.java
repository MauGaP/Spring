package com.mpedano.spring.controller;

import com.mpedano.spring.model.Student;
import com.mpedano.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("student/");
        
        List<Student> list = studentService.listAllStudents();
        model.addObject("listStudent", list);

        return model;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView addStudent() {
        ModelAndView model = new ModelAndView("student/student_form");

        Student user = new Student();
        model.addObject("studentForm", user);

        return model;
    }

    @RequestMapping(value = "/update/{userId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("userId") int userId) {
        ModelAndView model = new ModelAndView("student/student_form");

        Student student = studentService.findStudentById(userId);
        model.addObject("studentForm", student);

        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("studentForm") Student student) {
        if (student != null && student.getUserId() != null) {
            //update
            studentService.updateStudent(student);
        } else {
            //add new
            studentService.addStudent(student);
        }

        return new ModelAndView("redirect:/user/list");
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("userId") int userId) {
        studentService.deleteStudent(userId);

        return new ModelAndView("redirect:/user/list");
    }
}
