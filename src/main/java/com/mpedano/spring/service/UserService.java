package com.mpedano.spring.service;

import com.mpedano.spring.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> listAllUsers();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int userId);

    public Optional<User> findUserById(int userId);

    public List<User> getUsersByFirstName(String firstName);

    public List<User> getUsersByLastName(String lastName);
}
