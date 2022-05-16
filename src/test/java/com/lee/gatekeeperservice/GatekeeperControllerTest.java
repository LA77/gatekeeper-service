package com.lee.gatekeeperservice;

import com.lee.gatekeeperservice.controller.GatekeeperController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static  org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GatekeeperController.class)
@ExtendWith(SpringExtension.class)
public class GatekeeperControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllUsersTest() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().is2xxSuccessful());
    }
}
