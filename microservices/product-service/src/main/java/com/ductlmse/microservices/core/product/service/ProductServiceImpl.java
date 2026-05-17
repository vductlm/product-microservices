package com.ductlmse.microservices.core.product.service;

import com.ductlmse.microservices.api.composite.product.ProductAggregate;
import com.ductlmse.microservices.api.core.product.Product;
import com.ductlmse.microservices.api.core.product.ProductService;
import com.ductlmse.microservices.core.product.repositories.entities.ProductEntity;
import com.ductlmse.microservices.core.product.repositories.repository.ProductRepository;
import com.ductlmse.microservices.utils.services.ServiceUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ServiceUtils serviceUtils;


    @Override
    public Product getProduct(int productId) {
        System.out.println("Get product by id: " + productId);
        return new Product(
                productId,
                "name-" + productId,
                123, this.serviceUtils.getServiceAddress());
    }

    @Override
    public Product createProduct(ProductAggregate product) {
        ProductEntity productEntity = productMapper.apiToEntity(product);
        ProductEntity save = productRepository.save(productEntity);
        return productMapper.entityToApi(save);
    }

    @Override
    public void deleteProduct(int productId) {

    }


}
