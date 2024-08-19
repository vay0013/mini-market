package com.vay.minimarket.service;

import com.vay.minimarket.model.Product;
import com.vay.minimarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void updateProduct(long id, String name, double price) {
        productRepository.findById(id).ifPresentOrElse(
                product -> {
                    product.setName(name);
                    product.setPrice(price);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    public List<Product> getProductList() {
        return List.of();
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public List<Product> getProductByName(String productName) {
        return List.of();
    }
}
