package com.lee.gatekeeperservice.controller;

import com.lee.gatekeeperservice.model.User;
import com.lee.gatekeeperservice.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GatekeeperController {

    @Autowired
    private UserServiceInterface userService;

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("ONS")
    public void getONS() {
        String url = "https://api.beta.ons.gov.uk/v1/datasets";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(url, String.class);
        String productsJson = response.getBody();

        System.out.println(productsJson);
    }

}
