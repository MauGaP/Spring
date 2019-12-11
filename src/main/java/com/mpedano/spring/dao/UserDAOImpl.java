package com.mpedano.spring.dao;

import com.mpedano.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<User> listAll() {
        String sql = "SELECT userId, firstName, lastName, address FROM users;";

        List<User> list = namedParameterJdbcTemplate.query(sql, UserMapper.getSqlParameterByModel(null), new UserMapper());

        return list;
    }

    public void add(User user) {
        String sql = "INSERT INTO users(firstName, lastName, address) VALUES (:firstName, :lastName, :address);";

        namedParameterJdbcTemplate.update(sql, UserMapper.getSqlParameterByModel(user));
    }

    public void update(User user) {
        String sql = "UPDATE users SET firstName = :firstName, lastName = :lastName, address = :address WHERE userId = :userId;";

        namedParameterJdbcTemplate.update(sql, UserMapper.getSqlParameterByModel(user));
    }

    public void delete(Integer userId) {
        String sql = "DELETE FROM users WHERE userId = :userId";

        namedParameterJdbcTemplate.update(sql, UserMapper.getSqlParameterByModel(new User(userId)));
    }

    public User findById(Integer userId) {
        String sql = "SELECT * FROM users WHERE userId = :userId";

        return namedParameterJdbcTemplate.queryForObject(sql, UserMapper.getSqlParameterByModel(new User(userId)), new UserMapper());
    }
}
