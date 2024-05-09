package com.example.repository;

import com.example.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParams() {
        Product product = productRepository.findByNameOrDescriptionSQLIndexParams("Effective Java", "");

        System.out.println(product);
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamsMethod() {
        Product product = productRepository.findByNameOrDescriptionSQLNamedParams("Core Java", "");
        System.out.println(product);
    }
}
