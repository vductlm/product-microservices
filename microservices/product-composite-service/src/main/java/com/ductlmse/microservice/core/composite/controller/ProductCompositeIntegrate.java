package com.ductlmse.microservice.core.composite.controller;

import com.ductlmse.microservices.api.composite.product.ProductAggregate;
import com.ductlmse.microservices.api.composite.product.ProductCompositeService;
import com.ductlmse.microservices.api.core.product.Product;
import com.ductlmse.microservices.api.core.recommendation.Recommendation;
import com.ductlmse.microservices.api.core.recommendation.RecommendationService;
import com.ductlmse.microservices.api.core.review.Review;
import com.ductlmse.microservices.api.core.review.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductCompositeIntegrate implements ProductCompositeService, RecommendationService, ReviewService {

    private final RestTemplate restTemplate;

    @Value("${app.product-service.host}")
    private String productServiceUrl;
    @Value("${app.product-service.port}")
    private int productServicePort;

    @Value("${app.recommendation-service.host}")
    private String recommendationServiceUrl;
    @Value("${app.recommendation-service.port}")
    private int recommendationServicePort;

    @Value("${app.review-service.host}")
    private String reviewServiceServiceUrl;
    @Value("${app.review-service.port}")
    private int reviewServicePort;

    @Override
    public ProductAggregate getProduct(int productId) {
        return null;
    }

    @Override
    public void createProduct(ProductAggregate product) {

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
