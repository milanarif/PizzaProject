package com.milanarif.pizzaproject.repositories;

import com.milanarif.pizzaproject.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByName(String searchTerm);

    List<Pizza> findAllByIngredientsContains(String searchTerm);
}
