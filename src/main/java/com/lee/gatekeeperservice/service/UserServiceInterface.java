package com.lee.gatekeeperservice.service;

import com.lee.gatekeeperservice.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceInterface {
    List<User> getAllUsers();
}
