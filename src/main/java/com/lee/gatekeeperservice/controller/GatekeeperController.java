package com.lee.gatekeeperservice.controller;

import com.lee.gatekeeperservice.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GatekeeperController {

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(
                new User("Bob",
                        "Jones")
        );
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

}
