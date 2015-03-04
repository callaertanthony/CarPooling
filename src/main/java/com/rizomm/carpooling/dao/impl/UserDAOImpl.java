package com.rizomm.carpooling.dao.impl;

import com.rizomm.carpooling.dao.UserDAO;
import com.rizomm.carpooling.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonycallaert on 28/02/15.
 */
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public User findByUserName(String username){
        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession()
                .createQuery("from User where username = ?")
                .setParameter(0, username)
                .list();

        if(users.size() > 0){
            return users.get(0);
        } else {
            return null;
        }
    }
}
