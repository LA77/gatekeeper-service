package com.lee.gatekeeperservice.controller;

import com.lee.gatekeeperservice.controller.GatekeeperController;
import com.lee.gatekeeperservice.model.User;
import com.lee.gatekeeperservice.service.UserServiceInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static  org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

@WebMvcTest(controllers = GatekeeperController.class)
@ExtendWith(SpringExtension.class)
public class GatekeeperControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceInterface userService;

    @Test
    void getAllUsersTest() throws Exception {
        given(userService.getAllUsers())
                .willReturn(Arrays.asList(new User("James", "Bond")));
        mockMvc.perform(get("/api/users")).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[*].firstName").value("James"));
    }
}
