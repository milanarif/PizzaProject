package com.milanarif.pizzaproject.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PizzaDto {
    private String name;
    private int price;
    private String ingredients;
}
