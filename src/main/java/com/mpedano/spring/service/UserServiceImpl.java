package com.mpedano.spring.service;

import com.mpedano.spring.model.User;
import com.mpedano.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDAO userDao;

    @Autowired
    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
}
