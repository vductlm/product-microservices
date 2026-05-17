package com.ductlmse.microservice.core.recommendation.repositories;


import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recommendations")
@CompoundIndex(name = "prod-rec-id", unique = true, def = "{'productid' = 1, 'recommendationid' = 1}")
public class RecommendationEntity {
}
