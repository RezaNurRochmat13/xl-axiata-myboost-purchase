package com.myboost.purchase.service;

import com.myboost.purchase.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllActiveUsers();
    User findUserById(Long id);
    User saveUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
