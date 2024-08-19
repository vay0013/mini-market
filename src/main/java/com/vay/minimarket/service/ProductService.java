package com.vay.minimarket.service;

import com.vay.minimarket.model.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);

    void deleteProduct(Product product);

    void updateProduct(Product product);

    List<Product> getProductList();

    Product getProductById(int productId);

    List<Product> getProductByName(String productName);
//    List<Product> getProductByCategory(int categoryId);
}
