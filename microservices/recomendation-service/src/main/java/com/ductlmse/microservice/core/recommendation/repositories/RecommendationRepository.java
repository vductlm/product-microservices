package com.ductlmse.microservice.core.recommendation.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends CrudRepository<RecommendationEntity, Long> {
    List<RecommendationEntity> findByProductId(Long productId);

}
