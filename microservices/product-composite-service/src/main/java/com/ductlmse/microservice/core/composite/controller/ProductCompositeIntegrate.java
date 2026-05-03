package com.ductlmse.microservice.core.composite.controller;

import com.ductlmse.microservices.api.composite.product.ProductAggregate;
import com.ductlmse.microservices.api.composite.product.ProductCompositeService;
import com.ductlmse.microservices.api.product.Product;
import com.ductlmse.microservices.api.recommendation.Recommendation;
import com.ductlmse.microservices.api.recommendation.RecommendationService;
import com.ductlmse.microservices.api.review.Review;
import com.ductlmse.microservices.api.review.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductCompositeIntegrate implements ProductCompositeService, RecommendationService, ReviewService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;

    public ProductCompositeIntegrate(
            RestTemplate restTemplate,
            ObjectMapper objectMapper,
            @Value("${app.product-service.host}")
            String productServiceUrl,
            @Value("${app.recommendation-service.host}")
            String recommendationServiceUrl,
            @Value("${app.recommendation-service.host}")
            String reviewServiceUrl) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.productServiceUrl = productServiceUrl;
        this.recommendationServiceUrl = recommendationServiceUrl;
        this.reviewServiceUrl = reviewServiceUrl;
    }

    @Override
    public ProductAggregate getProduct(int productId) {
        return null;
    }

    private Product getProductDetails(int productId) {
        String url = "http://%s/products/%d".formatted(this.productServiceUrl, productId);
        return this.restTemplate.getForObject(url, Product.class);
    }
    public List<Recommendation> getRecommendations(int productId) {
        String url = "http://%s/recommendation?productId=%d".formatted(this.recommendationServiceUrl, productId);
        return this.restTemplate.exchange(url, HttpMethod.GET, null, new
                ParameterizedTypeReference<List<Recommendation>>() {
                }).getBody();
    }

    public List<Review> getReviews(int productId) {
        String url = "http://%s/review?productId=%d".formatted(this.reviewServiceUrl, productId);
        return this.restTemplate.exchange(url, HttpMethod.GET, null, new
                ParameterizedTypeReference<List<Review>>() {
                }).getBody();
    }

}
