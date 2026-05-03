package com.ductlmse.microservices.api.product;

public class Product {

    private final int productId;
    private final String name;
    private final double weight;
    private final String serviceAddress;

    public Product(int productId, String name, double weight, String serviceAddress) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.serviceAddress = serviceAddress;
    }

}
