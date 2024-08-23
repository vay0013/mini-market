package com.vay.minimarket.service;

import com.vay.minimarket.model.Product;
import com.vay.minimarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void createProduct(String name, double price) {
        productRepository.save(new Product(null, name, price));
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
            return productRepository.findAllByNameLikeIgnoreCase("%" + filter + "%");
        }
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        return productRepository.findById(productId).orElseThrow(NoSuchElementException::new);
    }
}
