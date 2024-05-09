package com.example.springboot.repository;

import com.example.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p from Product p where p.name like concat('%', :query, '%') or p.description like concat('%', :query, '%')")
    List<Product> searchProducts(String query);

    @Query(value = "SELECT * from tbl_products p where p.name like concat('%', :query, '%') or p.description like concat('%', :query, '%')",
                    nativeQuery = true)
    List<Product> searchProductsSQL(String query);


}
