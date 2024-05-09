package com.example.springboot.services;

import com.example.springboot.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);
}
