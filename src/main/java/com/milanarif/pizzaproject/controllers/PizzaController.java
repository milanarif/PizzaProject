package com.milanarif.pizzaproject.controllers;

import com.milanarif.pizzaproject.entities.Pizza;
import com.milanarif.pizzaproject.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String id;

    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    //TODO
    @GetMapping("/pizzas")
    public List<Pizza> pizzas() {
        return null;
    }


    @GetMapping("pizzas/test")
    public String test() {
        return id;
    }
}
