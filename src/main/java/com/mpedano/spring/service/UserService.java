package com.mpedano.spring.service;

import com.mpedano.spring.model.User;

import java.util.List;

public interface UserService {
    public List<User> listAllUsers();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    public User findUserById(int id);
}
