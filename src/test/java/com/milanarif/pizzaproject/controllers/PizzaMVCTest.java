package com.milanarif.pizzaproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.milanarif.pizzaproject.dtos.PizzaDto;
import com.milanarif.pizzaproject.repositories.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {PizzaController.class})
class PizzaMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PizzaRepository pizzaRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void postPizza() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/pizzas")
                .content(asJsonString(new PizzaDto("TESTPIZZA", 999, "TEST1,TEST2,TEST3")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("TESTPIZZA"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(999))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ingredients").value("TEST1,TEST2,TEST3"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
