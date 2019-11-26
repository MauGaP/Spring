package com.mpedano.spring.controller;

import com.mpedano.spring.model.Student;
import com.mpedano.spring.model.User;
import com.mpedano.spring.service.StudentService;
import com.mpedano.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getStudents() {
        List<Student> list = studentService.listAllStudents();
        return ResponseEntity
                .ok()
                .header("myHeader", "myValue")
                .body(list);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getStudent(@PathVariable("id") int id) {
        Optional<Student> student = studentService.findStudentById(id);
        return ResponseEntity
                .ok()
                .header("myHeader", "myValue")
                .body(student);
    }

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody Student student) {
        studentService.updateStudent(student);
    }
}
