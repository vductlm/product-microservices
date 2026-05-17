package com.ductlmse.microservices.core.product.repositories.repository;

import com.ductlmse.microservices.core.product.repositories.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends
        PagingAndSortingRepository<ProductEntity, Long>,
        CrudRepository<ProductEntity, Long> {

    Optional<ProductEntity> findProductById(Long id);
}
