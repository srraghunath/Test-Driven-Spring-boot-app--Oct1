package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void shouldReturnProductById() {
        Product product = new Product(1L, "Laptop", 50000);

        when(repository.findById(1L))
                .thenReturn(Optional.of(product));

        Product result = service.getProduct(1L);

        assertEquals("Laptop", result.getName());
        assertEquals(50000, result.getPrice());
    }

    @Test
    void shouldThrowExceptionWhenProductDoesNotExist() {
        when(repository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> service.getProduct(99L));
    }
}
