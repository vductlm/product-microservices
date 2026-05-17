package com.ductlmse.microservices.core.product.repositories.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductEntity {
    @Id
    private String id;
    @Version
    private int version;
    @Indexed(unique = true)
    private int productId;
    private String name;
    private int weight;

    public ProductEntity(int productId, String name, int weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
