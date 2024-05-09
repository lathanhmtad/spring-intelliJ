package com.example.repository;

import com.example.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedJPQLQuery() {
//        Product product = productRepository.getProductFromPrice(new BigDecimal(1000));
//        System.out.println(product);
    }

    @Test
    void namedJPQLQueries() {
        List<Product> products = productRepository.findAllOrderByNameDesc();

        products.forEach((product -> {
            System.out.println(product);
        }));

        Product product = productRepository.findByPrice(new BigDecimal(2000));
        System.out.println(product);
    }


    @Test
    void namedNativeSQLQuery() {
        Product p = productRepository.findByDescription("Product 2");
        System.out.println(p);
    }

    @Test
    void namedNativeSQLQueries() {
        Product product = productRepository.findByDescription("Book Java master");
        System.out.println(product);

        List<Product> products = productRepository.findAllOrderByNameAsc();

        products.forEach((p) -> {
            System.out.println(p);
        });
    }
}
