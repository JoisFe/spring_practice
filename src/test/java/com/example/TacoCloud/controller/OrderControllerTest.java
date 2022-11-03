package com.example.TacoCloud.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
@WebMvcTest(OrderController.class)
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
        mockMvc.perform(post("/orders")
                   .param("deliveryName", "haha")
                   .param("deliveryStreet", "haha")
                   .param("deliveryCity", "haha")
                   .param("deliveryState", "haha")
                   .param("deliveryZip", "haha")
                   .param("ccNumber", "371449635398431")
                   .param("ccExpiration", "07/95")
                   .param("ccCVV", "23"))
               .andDo(print())
               .andExpect(status().is3xxRedirection());
    }

    @Test
    void processOrderHasValidationError() throws Exception {
        mockMvc.perform(post("/orders"))
               .andExpect(status().isOk())
               .andExpect((view().name("orderForm")));
    }
}