package com.vay.minimarket.service;

import com.vay.minimarket.model.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    void createProduct(String name, double price);

    void deleteProduct(long productId);

    void updateProduct(long id, String name, double price);

    List<Product> getAllProducts(String filter);

    Product getProductById(long productId);
}
