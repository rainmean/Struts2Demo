package com.oaec.sd.dao;

import com.oaec.sd.entity.User;

import java.util.List;

public interface UserDao {
    int create(User user);
    void update(User user);
    void delete(User user);
    List<User> findAll();
    User findById(int id);
    User findByUsername(String username);
}
