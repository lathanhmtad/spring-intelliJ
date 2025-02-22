package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@NamedQuery(
//        name = "Product.getProductFromPrice",
//        query = "SELECT p from Product p where p.price = ?1"
//)
@NamedQueries(
        {
                @NamedQuery(
                        name =  "Product.findAllOrderByNameDesc",
                        query = "SELECT p from Product p order by p.name DESC"
                ),
                @NamedQuery(
                        name = "Product.findByPrice",
                        query = "SELECT p FROM Product p where p.price = :price"
                )
        }
)

//@NamedNativeQuery(
//        name = "Product.findByDescription",
//        query = "SELECT * FROM tbl_products p where p.description = ?1",
//        resultClass = Product.class
//)
@NamedNativeQueries( {
        @NamedNativeQuery(
                name = "Product.findByDescription",
                query = "SELECT * FROM tbl_products p where p.description = ?1",
                resultClass = Product.class
        ),
        @NamedNativeQuery(
                name = "Product.findAllOrderByNameAsc",
                query = "select * from tbl_products order by name asc",
                resultClass = Product.class
        )
})

@Table(
        name = "tbl_products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "sku"
                )
        }
)
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long id;
    @Column(name="stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory category;

}
