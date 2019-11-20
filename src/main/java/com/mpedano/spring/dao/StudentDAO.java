package com.mpedano.spring.dao;

import com.mpedano.spring.model.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> listAllStudents();

    public void addStudent(Student student);

    public void updateStudent(Student student);

    public void deleteStudent(int userId);

    public Student findStudentById(int userId);
}
