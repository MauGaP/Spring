package com.mpedano.spring.service;

import com.mpedano.spring.model.Student;
import com.mpedano.spring.repository.StudentRepository;
import com.mpedano.spring.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAllStudents() {
        Iterable<Student> list = studentRepository.findAll();
        return Utils.toList(list);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int userId) {
        studentRepository.deleteById(userId);
    }

    public Optional<Student> findStudentById(int userId) {
        return studentRepository.findById(userId);
    }
}
