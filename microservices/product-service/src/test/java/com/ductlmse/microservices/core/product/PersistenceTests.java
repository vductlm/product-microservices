package com.ductlmse.microservices.core.product;

import com.ductlmse.microservices.core.product.repositories.entities.ProductEntity;
import com.ductlmse.microservices.core.product.repositories.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.security.PEMRecord;
import java.util.Optional;

@DataMongoTest
public class PersistenceTests {
    @Autowired
    private ProductRepository productRepository;
    private ProductEntity productEntity;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        ProductEntity product = new ProductEntity(1, "n", 1);
        productRepository.save(product);
    }

    @Test
    void create() {
        ProductEntity product = new ProductEntity(2, "n", 2);
        productRepository.save(product);
        Optional<ProductEntity> existedProduct = productRepository.findById(1L);


    }
}
