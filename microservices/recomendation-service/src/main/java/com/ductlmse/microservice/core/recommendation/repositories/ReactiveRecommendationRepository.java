package com.ductlmse.microservice.core.recommendation.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface ReactiveRecommendationRepository extends ReactiveCrudRepository<RecommendationEntity, Long> {
    Flux<RecommendationEntity> findByProductId(Long productId);

}
