package com.mpedano.spring.service;

import com.mpedano.spring.model.User;
import com.mpedano.spring.repository.UserRepository;
import com.mpedano.spring.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUsers() {
        Iterable<User> list = userRepository.findAll();
        return Utils.toList(list);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public Optional<User> findUserById(int userId) {
        return userRepository.findById(userId);
    }
}
