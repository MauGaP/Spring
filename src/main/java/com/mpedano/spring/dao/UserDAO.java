package com.mpedano.spring.dao;

import com.mpedano.spring.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> listAllUsers();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int userId);

    public User findUserById(int userId);
}
