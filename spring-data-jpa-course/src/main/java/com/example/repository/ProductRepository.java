package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Returns the found product entry by using its name as search criteria.
     * If no product entry is found, this method returns null.
     */
    Product findByName(String name);

    /**
     * Returns an Optional which contains the found product entry
     * by using its id as search criteria. If no product entry
     * is found, this method returns an empty Optional
     */
    Optional<Product> findById(Long id);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    /**
     * Return the distinct product entry whose name is given as a method parameter
     * If no product entry is found, this method returns null.
     */
    Product findDistinctByName(String name);

    // Define JPQL query using @Query annotation with index or position parameters
    @Query("SELECT p from Product p where p.name = ?1 or p.description = ?2")
    Product findByNameOrDescriptionJQPLIndexParam(String name, String description);


    // Define JPQL query using @Query annotation with named parameters
    @Query("SELECT p from Product p where p.name = :name or p.description = :description")
    Product findByNameOrDescriptionJPQLNamedParams(@Param("name") String name,
                                                   @Param("description") String description);

    // Define Native SQL query using @Query annotation with index or position parameters
    @Query(value = "select * from tbl_products p where p.name = ?1 or p.description = ?2", nativeQuery = true)
    Product findByNameOrDescriptionSQLIndexParams(String name, String description);


    // Define Native SQL query using @Query annotation with Named parameters
    @Query(value = "Select * from tbl_products p where p.name = :name or p.description = :description", nativeQuery = true)
    Product findByNameOrDescriptionSQLNamedParams(@Param("name") String name,
                                                  @Param("description") String description);

    // Define Named JPQL query
//    Product getProductFromPrice(BigDecimal price);

    Product findByPrice(@Param("price") BigDecimal price);

    List<Product> findAllOrderByNameDesc();

    // Define Named native SQL query
    @Query(nativeQuery = true)
    Product findByDescription(String description);

    List<Product> findAllOrderByNameAsc();


    @Query("Select p From Product p where p.name like %:keyword% or p.description like %:keyword%")
    Page<Product> searchProducts(@Param("keyword") String keyword, Pageable pageable);
}
