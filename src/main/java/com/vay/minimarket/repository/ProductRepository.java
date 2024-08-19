package com.vay.minimarket.repository;

import com.vay.minimarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
