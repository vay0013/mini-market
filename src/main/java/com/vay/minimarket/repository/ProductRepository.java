package com.vay.minimarket.repository;

import com.vay.minimarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameLikeIgnoreCase(String name);
}