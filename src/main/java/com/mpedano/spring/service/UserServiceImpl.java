package com.mpedano.spring.service;

import com.mpedano.spring.model.User;
import com.mpedano.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    @Autowired
    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public List<User> listAllUsers() {
        return userDao.listAll();
    }

    public void addUser(User user) {
        userDao.add(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(int userId) {
        userDao.delete(userId);
    }

    public User findUserById(int userId) {
        return userDao.findById(userId);
    }
}
