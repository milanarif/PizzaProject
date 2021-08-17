package com.milanarif.pizzaproject.controllers;

import com.milanarif.pizzaproject.repositories.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


// - UNIT TEST SOM EGENTLIGEN INTE TESTAR NÅGOT VETTIGT!
@ExtendWith(MockitoExtension.class)
class PizzaControllerTest {

    @Mock
    PizzaRepository pizzaRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void getAllPizzas() {
        PizzaController pizzaController = new PizzaController(pizzaRepository, modelMapper);
        assertThat(pizzaController.pizzas().isEmpty());
    }

}