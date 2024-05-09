package com.example.repository;

import com.example.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJQPLIndexParam() {
        Product product = productRepository.findByNameOrDescriptionJQPLIndexParam("Core Java", "");

        System.out.println(product);
    }

    @Test
    void findByNameOrDescriptionJQPLNamedParamsMethod() {
        Product product = productRepository.findByNameOrDescriptionJQPLIndexParam("", "Book Java master");
        System.out.println(product);
    }

}
