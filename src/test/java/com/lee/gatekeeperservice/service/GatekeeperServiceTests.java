package com.lee.gatekeeperservice.service;

import com.lee.gatekeeperservice.dao.UserDao;
import com.lee.gatekeeperservice.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class GatekeeperServiceTests {

    @MockBean
    UserDao userDao;

    @Autowired
    UserServiceInterface userService;

    @Configuration
    public static class Config {
        @Bean
        public UserServiceInterface getUserService() {
            return new UserService();
        }
    }

    @Test
    void getAllUsersTest() {
        User user = new User("Fred", "Bloggs");
        given(userDao.getAllUsers())
                .willReturn(Arrays.asList(user));
        assertEquals(Arrays.asList(user), userService.getAllUsers());
    }
}
