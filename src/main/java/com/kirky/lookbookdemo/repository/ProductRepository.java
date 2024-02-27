package com.kirky.lookbookdemo.repository;

import com.kirky.lookbookdemo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByTitleContainingIgnoreCase(String search, Pageable pageable);
}
