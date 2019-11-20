package com.mpedano.spring.dao;

import com.mpedano.spring.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setAddress(rs.getString("address"));
        return user;
    }

    public static SqlParameterSource getSqlParameterByModel(User user) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        if (user != null) {
            paramSource.addValue("userId", user.getUserId());
            paramSource.addValue("firstName", user.getFirstName());
            paramSource.addValue("lastName", user.getLastName());
            paramSource.addValue("address", user.getAddress());
        }
        return paramSource;
    }
}
