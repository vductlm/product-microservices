package com.ductlmse.microservices.core.product.service;

import com.ductlmse.microservices.api.product.Product;
import com.ductlmse.microservices.api.product.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProduct(int productId) {
        return null;
    }
}
