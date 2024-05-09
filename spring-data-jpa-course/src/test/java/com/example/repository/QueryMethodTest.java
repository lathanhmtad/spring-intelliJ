package com.example.repository;

import com.example.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product2");

        System.out.println(product);
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(11L).get();
        System.out.println(product);
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("product3", "product 214 description");

        products.forEach((p) -> {
            System.out.println(p);
        });
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription("product3", "product 3 description");

        products.forEach((p) -> {
            System.out.println(p);
        });
    }
}
