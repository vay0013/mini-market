package com.vay.minimarket.service;

import com.vay.minimarket.model.Product;
import com.vay.minimarket.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DefaultProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    DefaultProductService service;

    @Test
    void createProduct_CreatesProduct() {
        // given
        var name = "new product";
        var price = 10.00;

        doReturn(new Product(1L, "new product", 10.00))
                .when(productRepository)
                .save(new Product(null, "new product", 10.00));

        // when
        service.createProduct(name, price);

        // then
        verify(productRepository, times(1))
                .save(new Product(null, "new product", 10.00));
    }

    @Test
    void deleteProduct_DeletesProduct() {
        // given
        var id = 1L;

        // when
        service.deleteProduct(id);

        // then
        verify(productRepository, times(1)).deleteById(id);
    }

    @Test
    void updateProduct_ProductExist_UpdatesProduct() {
        var id = 1L;
        var newName = "new name of product";
        var newPrice = 10.00;
        var product = new Product(1L, "product", 1.0);

        doReturn(new Product(id, "new product", 10.00))
                .when(productRepository).save(new Product(null, "new product", 10.00));
    }

    @Test
    void getAllProducts_WithoutFilter_ReturnsAllProducts() {
        // given
        var products = LongStream.range(1, 4)
                .mapToObj(i -> new Product(i, "product №$d".formatted(i), 10.00))
                .toList();

        doReturn(products).when(productRepository).findAll();

        // when
        var result = service.getAllProducts(null);

        // then
        assertNotNull(result);
        assertEquals(products, result);
    }

    @Test
    void getProductById() {
    }

    @Test
    void getProductByName() {
    }
}