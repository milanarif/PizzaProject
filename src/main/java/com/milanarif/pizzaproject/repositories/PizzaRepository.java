package com.milanarif.pizzaproject.repositories;

import com.milanarif.pizzaproject.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
