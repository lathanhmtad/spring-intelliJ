package com.example.repository;

import com.example.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product object
        Product product = new Product();
        product.setName("product1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));

        // save product
        Product savedObject = productRepository.save(product);

        // display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }


    @Test
    void updateUsingSaveMethod() {
        // find or retrieve on entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 description");

        // save updated entity
        productRepository.save(product);
    }


    @Test
    void findByIdMethod() {
        Long id = 1L;

        Product product = productRepository.findById(id).get();
        System.out.println(product);
    }

    @Test
    void saveAllMethod() {
        Product product1 = new Product();
        product1.setName("product1");
        product1.setDescription("product 1 description");
        product1.setSku("100ABC");
        product1.setPrice(new BigDecimal(100));

        Product product2 = new Product();
        product2.setName("product2");
        product2.setDescription("product 2 description");
        product2.setSku("200ABCd");
        product2.setPrice(new BigDecimal(200));

        Product product3 = new Product();
        product3.setName("product3");
        product3.setDescription("product 3 description");
        product3.setSku("300XYZ");
        product3.setPrice(new BigDecimal(300));

        Product product4 = new Product();
        product4.setName("product4");
        product4.setDescription("product 4 description");
        product4.setSku("400ABC");
        product4.setPrice(new BigDecimal(400));

        Product product5 = new Product();
        product5.setName("product5");
        product5.setDescription("product 5 description");
        product5.setSku("500DEF");
        product5.setPrice(new BigDecimal(500));

        Product product6 = new Product();
        product6.setName("product6");
        product6.setDescription("product 6 description");
        product6.setSku("600GHI");
        product6.setPrice(new BigDecimal(600));

        Product product7 = new Product();
        product7.setName("product7");
        product7.setDescription("product 7 description");
        product7.setSku("700JKL");
        product7.setPrice(new BigDecimal(700));

        Product product8 = new Product();
        product8.setName("product8");
        product8.setDescription("product 8 description");
        product8.setSku("800MNO");
        product8.setPrice(new BigDecimal(800));

        Product product9 = new Product();
        product9.setName("product9");
        product9.setDescription("product 9 description");
        product9.setSku("900PQR");
        product9.setPrice(new BigDecimal(900));

        Product product10 = new Product();
        product10.setName("product10");
        product10.setDescription("product 10 description");
        product10.setSku("1000STU");
        product10.setPrice(new BigDecimal(1000));

        Product product11 = new Product();
        product11.setName("product11");
        product11.setDescription("product 11 description");
        product11.setSku("1100VWX");
        product11.setPrice(new BigDecimal(1100));

        Product product12 = new Product();
        product12.setName("product12");
        product12.setDescription("product 12 description");
        product12.setSku("1200YZA");
        product12.setPrice(new BigDecimal(1200));

        Product product13 = new Product();
        product13.setName("product13");
        product13.setDescription("product 13 description");
        product13.setSku("1300ABC");
        product13.setPrice(new BigDecimal(1300));

        Product product14 = new Product();
        product14.setName("product14");
        product14.setDescription("product 14 description");
        product14.setSku("1400DEF");
        product14.setPrice(new BigDecimal(1400));

        Product product15 = new Product();
        product15.setName("product15");
        product15.setDescription("product 15 description");
        product15.setSku("1500GHI");
        product15.setPrice(new BigDecimal(1500));

        Product product16 = new Product();
        product16.setName("product16");
        product16.setDescription("product 16 description");
        product16.setSku("1600JKL");
        product16.setPrice(new BigDecimal(1600));

        Product product17 = new Product();
        product17.setName("product17");
        product17.setDescription("product 17 description");
        product17.setSku("1700MNO");
        product17.setPrice(new BigDecimal(1700));

        Product product18 = new Product();
        product18.setName("product18");
        product18.setDescription("product 18 description");
        product18.setSku("1800PQR");
        product18.setPrice(new BigDecimal(1800));

        Product product19 = new Product();
        product19.setName("product19");
        product19.setDescription("product 19 description");
        product19.setSku("1900STU");
        product19.setPrice(new BigDecimal(1900));

        List<Product> productList = List.of(
                product1, product2, product3, product4, product5, product6, product7, product8, product9,
                product10, product11, product12, product13, product14, product15, product16, product17,
                product18, product19
        );

        productRepository.saveAll(productList);
    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
//        Iterable<Product> ps = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });

    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;

        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        // find an entity by id
        Long id = 3L;
        Product product = productRepository.findById(id).get();

        // delete(entity)
        productRepository.delete(product);

    }

    @Test
    void deleteAllMethod() {
//        productRepository.deleteAll();

        Product p1 = productRepository.findById(9L).get();

        Product p2 = productRepository.findById(10L).get();

        productRepository.deleteAll(List.of(p1, p2));

    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod() {
        Long id = 11L;
        System.out.println(productRepository.existsById(id));
    }

    @Test
    void findDistinctByNameMethod() {
        Product p = productRepository.findDistinctByName("product2");
        System.out.println(p);
    }
}