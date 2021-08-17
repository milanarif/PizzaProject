package com.milanarif.pizzaproject.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.net.URI;
import java.net.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaEndToEndTest {

    @LocalServerPort
    private int port;

    @Test
    void getPizzasReturnsListofPizzas() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:" + port + "/pizzas"))
                .build();
        var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).join();

        //TODO
        assertThat(response.statusCode()).isEqualTo(200);
        //TODO
        assertThat(response.body()).isEqualTo("...");
    }
}