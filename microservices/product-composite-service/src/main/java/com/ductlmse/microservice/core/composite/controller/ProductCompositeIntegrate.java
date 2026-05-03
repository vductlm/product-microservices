package com.ductlmse.microservice.core.composite.controller;

import com.ductlmse.microservices.api.composite.product.ProductAggregate;
import com.ductlmse.microservices.api.composite.product.ProductCompositeService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductCompositeIntegrate implements ProductCompositeService {

    private final RestTemplate restTemplate;

    public ProductCompositeIntegrate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductAggregate getProduct(int productId) {
        return null;
    }
}
