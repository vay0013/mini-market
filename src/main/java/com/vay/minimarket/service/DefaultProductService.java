package com.vay.minimarket.service;

import com.vay.minimarket.model.Product;
import com.vay.minimarket.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
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
    @Transactional
    public void deleteProduct(long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAllProducts(String filter) {
        if (filter != null && !filter.isBlank()) {
            return productRepository.findAll().stream()
                    .map(product -> {
                        product.
                    })
        }
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        return productRepository.findById(productId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepository.findProductByNameLikeIgnoreCase("%" + productName + "%")
                .orElseThrow(NoSuchElementException::new);
    }
}
