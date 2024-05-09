package com.example.repository;

import com.example.entity.Product;
import com.example.entity.ProductCategory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("books");
        productCategory.setCategoryDescription("books description");

        Product p1 = new Product();
        p1.setName("Core Java");
        p1.setPrice(new BigDecimal(1000));
        p1.setImageUrl("image1.png");
        p1.setSku("ABCDE");
        p1.setActive(true);
        p1.setCategory(productCategory);
        productCategory.getProducts().add(p1);

        Product p2 = new Product();
        p2.setName("Effective Java");
        p2.setPrice(new BigDecimal(2000));
        p2.setImageUrl("image2.png");
        p2.setSku("BCAD");
        p2.setActive(true);
        p2.setCategory(productCategory);
        productCategory.getProducts().add(p2);

        productCategoryRepository.save(productCategory);
    }

    @Test
    @Transactional
    void fetchProductCategory() {
        ProductCategory category = productCategoryRepository.findById(1L).get();
        category.getProducts();
        System.out.println(category);
        System.out.println(category.getProducts());
    }

}