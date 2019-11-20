package com.mpedano.spring.dao;

import com.mpedano.spring.model.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setUserId(rs.getInt("userId"));
        student.setFirstName(rs.getString("firstName"));
        student.setLastName(rs.getString("lastName"));
        student.setAddress(rs.getString("address"));
        student.setGrade(rs.getString("grade"));
        student.setAverage(rs.getDouble("average"));
        return student;
    }

    public static SqlParameterSource getSqlParameterByModel(Student student) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        if (student != null) {
            paramSource.addValue("userId", student.getUserId());
            paramSource.addValue("firstName", student.getFirstName());
            paramSource.addValue("lastName", student.getLastName());
            paramSource.addValue("address", student.getAddress());
            paramSource.addValue("grade", student.getGrade());
            paramSource.addValue("average", student.getAverage());
        }
        return paramSource;
    }
}