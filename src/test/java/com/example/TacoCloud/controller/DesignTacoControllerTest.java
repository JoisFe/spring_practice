package com.example.TacoCloud.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author : 조재철
 * @since 1.0
 */
@WebMvcTest
class DesignTacoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void showDesignForm() throws Exception {
        mockMvc.perform(get("/design"))
               .andExpect(status().isOk())
               .andExpect(view().name("design"));
    }
}