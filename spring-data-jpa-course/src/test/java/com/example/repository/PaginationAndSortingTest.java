package com.example.repository;

import com.example.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void pagination() {
        int pageNumber = 3;
        int pageSize = 5;

        // create pageable object
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        // findAll method and pass pageable instance
        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach((p) -> {
            System.out.println(p);
        });

        // total pages
        int totalPages = page.getTotalPages();

        // total elements
        long totalElements = page.getTotalElements();

        // number of elements
        int numberOfElements = page.getNumberOfElements();

        // size
        int size = page.getSize();

        // last
        boolean isLast = page.isLast();

        // first
        boolean isFirst = page.isFirst();

        System.out.println("total page -> " + totalPages);
        System.out.println("total elements -> " + totalElements);
        System.out.println("number of elements -> " + numberOfElements);
        System.out.println("size -> " + size);
        System.out.println("is last -> " + isLast);
        System.out.println("is first -> " + isFirst);

    }

    @Test
    void sorting() {
        String sortBy = "name";
        String sortDir = "desc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        List<Product> products = productRepository.findAll(sort);

        products.forEach((p) -> {
            System.out.println(p);
        });
    }

    @Test
    void sortingByMultipleField() {
        String sortBy = "name";
        String sortByDesc = "description";

        String sortDir = "desc";

        Sort sortByName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Sort sortByDescription = "asc".equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                                Sort.by(sortByDesc).ascending() : Sort.by(sortByDesc).descending();

        Sort groupBySort = sortByName.and(sortByDescription);

        List<Product> products = productRepository.findAll(groupBySort);

        products.forEach((p) -> {
            System.out.println(p);
        });
    }


    @Test
    void paginationAndSortingTogether() {
        String sortBy = "price";
        String sortDir = "desc";

        int pageNumber = 1;
        int pageSize = 3;

        // Sort object
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                    Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // Pageable object
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach((p) -> {
            System.out.println(p);
        });

        // total pages
        int totalPages = page.getTotalPages();

        // total elements
        long totalElements = page.getTotalElements();

        // number of elements
        int numberOfElements = page.getNumberOfElements();

        // size
        int size = page.getSize();

        // last
        boolean isLast = page.isLast();

        // first
        boolean isFirst = page.isFirst();

        System.out.println("total page -> " + totalPages);
        System.out.println("total elements -> " + totalElements);
        System.out.println("number of elements -> " + numberOfElements);
        System.out.println("size -> " + size);
        System.out.println("is last -> " + isLast);
        System.out.println("is first -> " + isFirst);
    }

    @Test
    void searchProductsMethod() {
        int pageNumber = 0;
        int pageSize = 2;

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<Product> page = productRepository.searchProducts("producta", pageable);

        List<Product> products = page.getContent();

        products.forEach((p) -> {
            System.out.println(p);
        });
    }
}
