package com.mpedano.spring.dao;

import com.mpedano.spring.model.Student;
import com.mpedano.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mpedano.spring.dao.StudentMapper.getSqlParameterByModel;

@Repository
public class StudentDAOImpl implements StudentDAO {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    UserDAO userDAO;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Student> listAllStudents() {
        String sql = "SELECT users.userId, users.firstName, users.lastName, users.address, students.grade, students.average " +
                "FROM students " +
                "INNER JOIN users ON students.userId=users.userId ";

        List<Student> list = namedParameterJdbcTemplate.query(sql, StudentMapper.getSqlParameterByModel(null), new StudentMapper());

        return list;
    }

    @Transactional
    public void addStudent(Student student) {
        String addStudentSql = "INSERT INTO students (userId, grade, average) " +
                "VALUES (LAST_INSERT_ID(), :grade, :average); ";

        User user = new User();
        user.setFirstName(student.getFirstName());
        user.setLastName(student.getLastName());
        user.setAddress(student.getAddress());
        userDAO.addUser(user);
        namedParameterJdbcTemplate.update(addStudentSql, getSqlParameterByModel(student));

    }

    @Transactional
    public void updateStudent(Student student) {
        String sql = "UPDATE students s SET grade = :grade, average = :average " +
                "WHERE s.userId = :userId; ";

        User user = new User();
        user.setFirstName(student.getFirstName());
        user.setLastName(student.getLastName());
        user.setAddress(student.getAddress());
        userDAO.addUser(user);
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(student));
    }

    public void deleteStudent(int userId) {
        String sql = "DELETE FROM users u WHERE u.userId = :userId; " +
                "DELETE FROM students s WHERE s.userId = :userId; ";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Student(userId)));
    }

    public Student findStudentById(int userId) {
        String sql = "SELECT u.userId, u.firstName, u.lastName, u.address, s.grade, s.average " +
                "FROM students s " +
                "INNER JOIN users u " +
                "ON s.userId = u.userId " +
                "WHERE u.userId = :userId ";

        return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Student(userId)), new StudentMapper());
    }
}
