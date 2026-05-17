package com.ductlmse.microservices.core.product.repositories.repository;

import com.ductlmse.microservices.core.product.repositories.entities.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveProductRepository
        extends ReactiveCrudRepository<ProductEntity, Long> {

    Mono<ProductEntity> findByProductId(Long productId);

}
