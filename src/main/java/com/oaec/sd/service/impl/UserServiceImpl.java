package com.oaec.sd.service.impl;

import com.oaec.sd.dao.UserDao;
import com.oaec.sd.dao.impl.UserDaoImpl;
import com.oaec.sd.entity.User;
import com.oaec.sd.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public int register(String username, String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSex("保密");

        int id = userDao.create(user);
        return id;
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void create(User user) {
        userDao.create(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public Map<String, Object> login(String username, String password) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("ok", false);

        User user = userDao.findByUsername(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                resultMap.put("ok", true);
                resultMap.put("user", user);
            }else{
                resultMap.put("error", "登录失败！密码不正确！");
            }
        }else{
            resultMap.put("error", "登录失败！没有此用户！");
        }
        return resultMap;
    }
}
