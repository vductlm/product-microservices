package com.ductlmse.microservices.core.product.service;

import com.ductlmse.microservices.api.product.Product;
import com.ductlmse.microservices.api.product.ProductService;
import com.ductlmse.microservices.utils.services.ServiceUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ProductServiceImpl implements ProductService {

    private final ServiceUtils serviceUtils;

    public ProductServiceImpl(ServiceUtils ser) {
        this.serviceUtils = ser;
    }

    @Override
    public Product getProduct(int productId) {
        System.out.println("Get product by id: " + productId);
        return new Product(
                productId,
                "name-" + productId,
                123, this.serviceUtils.getServiceAddress());
    }
}
