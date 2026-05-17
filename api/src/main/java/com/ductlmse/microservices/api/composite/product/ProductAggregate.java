package com.ductlmse.microservices.api.composite.product;

import com.ductlmse.microservices.api.composite.recommendation.RecommendationSummary;
import com.ductlmse.microservices.api.composite.review.ReviewSummary;

import java.util.List;

public class ProductAggregate {

    private final int productId;
    private final String name;
    private final double weight;
    private final List<RecommendationSummary> recommendations;
    private final List<ReviewSummary> reviews;
    private final List<ServiceAddress> serviceAddresses;

    public ProductAggregate(int productId, String name, double weight, List<RecommendationSummary> recommendations, List<ReviewSummary> reviews, List<ServiceAddress> serviceAddresses) {

        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.recommendations = recommendations;
        this.reviews = reviews;
        this.serviceAddresses = serviceAddresses;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public List<RecommendationSummary> getRecommendations() {
        return recommendations;
    }

    public List<ReviewSummary> getReviews() {
        return reviews;
    }

    public List<ServiceAddress> getServiceAddresses() {
        return serviceAddresses;
    }
}
