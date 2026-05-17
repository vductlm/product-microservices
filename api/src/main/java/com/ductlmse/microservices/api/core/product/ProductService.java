package com.ductlmse.microservices.api.core.product;

import com.ductlmse.microservices.api.composite.product.ProductAggregate;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

public interface ProductService {

    @GetMapping(
            value = "/product/{productId}",
            produces = "application/json"
    )
    Product getProduct(@PathVariable("productId") int productId);


    @Operation(
            summary = "${api.product-composite.create-composite-product.summary}",
            description = "${api.product-composite.create-composite-product.description}"
    )
    @PostMapping(
            value = "/product-composite",
            consumes = "application/json"
    )
    Product createProduct(@RequestBody ProductAggregate product);

    @DeleteMapping("/product/{productId}")
    void deleteProduct(@PathVariable int productId);

}
