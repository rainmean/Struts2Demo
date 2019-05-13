package com.oaec.sd.dao.impl;

import com.oaec.sd.dao.UserDao;
import com.oaec.sd.entity.User;
import com.oaec.sd.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public int create(User user) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        int id = (int)session.save(user);
        session.getTransaction().commit();
        return id;
    }

    public void update(User user) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public void delete(User user) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

    public List<User> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from User";
        Query<User> query = session.createQuery(hql, User.class);
        List<User> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    public User findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    public User findByUsername(String username) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from User where username=:username";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("username", username);
        User user = query.uniqueResult();
        session.getTransaction().commit();
        return user;
    }
}
