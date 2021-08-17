package com.milanarif.pizzaproject;

import com.milanarif.pizzaproject.entities.Pizza;
import com.milanarif.pizzaproject.repositories.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(PizzaRepository pizzaRepository){
        return args -> {
            if (pizzaRepository.count() == 0) {
                pizzaRepository.save(new Pizza(0L, "Hawaii", 80, "Ost,Tomatsås,Skinka,Ananas"));
            }
        };
    }
}
