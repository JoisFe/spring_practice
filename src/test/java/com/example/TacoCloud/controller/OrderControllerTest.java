package com.example.TacoCloud.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : 조재철
 * @since 1.0
 */
@WebMvcTest
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void orderForm() throws Exception {
        mockMvc.perform(get("/orders/current"))
               .andExpect(status().isOk())
               .andExpect(view().name("orderForm"));
    }

    @Test
    void processOrder() throws Exception {
        mockMvc.perform(post("/orders/"))
            .andExpect(status().is3xxRedirection());
    }
}