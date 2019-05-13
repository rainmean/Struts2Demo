package com.oaec.sd.service;

import com.oaec.sd.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    int register(String username, String password);
    Map<String, Object> login(String username, String password);
    void update(User user);
    void create(User user);
    void delete(User user);
    List<User> findAll();
    User findById(int id);
}
