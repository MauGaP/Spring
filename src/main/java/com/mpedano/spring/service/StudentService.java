package com.mpedano.spring.service;

import com.mpedano.spring.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> listAllStudents();

    public void addStudent(Student student);

    public void updateStudent(Student student);

    public void deleteStudent(int userId);

    public Optional<Student> findStudentById(int userId);
}
