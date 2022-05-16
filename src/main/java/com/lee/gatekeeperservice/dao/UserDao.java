package com.lee.gatekeeperservice.dao;

import com.lee.gatekeeperservice.model.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserDao {

    private static User user = new User("James", "Bond");

    public List<User> getAllUsers() {
        return Arrays.asList(user);
    }
}
