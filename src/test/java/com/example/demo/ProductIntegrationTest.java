package com.example.demo;

import com.example.demo.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnProductById() {
        ResponseEntity<Product> response = restTemplate.getForEntity("http://localhost:" + port + "/products/1", Product.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        assertEquals("Laptop", response.getBody().getName());
        assertEquals(50000.0, response.getBody().getPrice());
    }

    @Test
    void shouldReturn404WhenProductNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/products/99", String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
