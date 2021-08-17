package com.milanarif.pizzaproject.controllers;

import com.milanarif.pizzaproject.dtos.PizzaDto;
import com.milanarif.pizzaproject.entities.Pizza;
import com.milanarif.pizzaproject.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PizzaController {

    private final PizzaRepository pizzaRepository;
    private final ModelMapper modelMapper;

    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String id;

    public PizzaController(PizzaRepository pizzaRepository, ModelMapper modelMapper) {
        this.pizzaRepository = pizzaRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/pizzas")
    public List<Pizza> pizzas() {
        return pizzaRepository.findAll();
    }

    @GetMapping("pizzas/test")
    public String test() {
        return id;
    }

    @PostMapping("/pizzas")
    public PizzaDto addPizza( @RequestBody PizzaDto pizzaDto) {
        Pizza pizza = modelMapper.map(pizzaDto, Pizza.class);
        pizzaRepository.save(pizza);
        return pizzaDto;
    }

    @DeleteMapping("/pizza/{id}")
    PizzaDto removePizza(@PathVariable("id") long id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if (pizza.isPresent()) {
            PizzaDto pizzaDto = modelMapper.map(pizza, PizzaDto.class);
            pizzaRepository.deleteById(id);
            return pizzaDto;
        }
        else return null;
    }

}
