package com.mpedano.spring.service;

import com.mpedano.spring.model.Student;
import com.mpedano.spring.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDao;

    @Autowired
    public void setStudentDAO(StudentDAO studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> listAllStudents() {
        return studentDao.listAll();
    }

    public void addStudent(Student student) {
        studentDao.add(student);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    public void deleteStudent(int userId) {
        studentDao.delete(userId);
    }

    public Student findStudentById(int userId) {
        return studentDao.findById(userId);
    }
}
