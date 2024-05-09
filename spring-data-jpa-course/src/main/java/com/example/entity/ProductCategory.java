package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String categoryDescription;

    @OneToMany( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        }, fetch = FetchType.LAZY,
            mappedBy = "category"
    )
    private List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                '}';
    }
}
