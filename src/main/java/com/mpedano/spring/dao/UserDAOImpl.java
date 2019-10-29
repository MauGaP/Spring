package com.mpedano.spring.dao;

import com.mpedano.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<User> listAllUsers() {
        String sql = "SELECT id, firstName, lastName, address FROM users;";

        List<User> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());

        return list;
    }

    private SqlParameterSource getSqlParameterByModel(User user) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        if (user != null) {
            paramSource.addValue("id", user.getId());
            paramSource.addValue("firstName", user.getFirstName());
            paramSource.addValue("lastName", user.getLastName());
            paramSource.addValue("address", user.getAddress());
        }
        return paramSource;
    }

    private static final class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setAddress(rs.getString("address"));
            return user;
        }
    }

    public void addUser(User user) {
        String sql = "INSERT INTO users(firstName, lastName, address) VALUES (:firstName, :lastName, :address);";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
    }

    public void updateUser(User user) {
        String sql = "UPDATE users SET firstName = :firstName, lastName = :lastName, address = :address WHERE id = :id;";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = :id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new User(id)));
    }

    public User findUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = :id";

        return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new User(id)), new UserMapper());
    }
}
