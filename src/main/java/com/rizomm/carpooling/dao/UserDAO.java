package com.rizomm.carpooling.dao;

import com.rizomm.carpooling.model.User;

/**
 * Created by anthonycallaert on 28/02/15.
 */
public interface UserDAO {
    User findByUserName(String username);
}
