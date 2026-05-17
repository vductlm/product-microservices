package com.ductlmse.microservices.core.product.service;

import com.ductlmse.microservices.api.composite.product.ProductAggregate;
import com.ductlmse.microservices.api.core.product.Product;
import com.ductlmse.microservices.core.product.repositories.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductEntity apiToEntity(ProductAggregate product);

    Product entityToApi(ProductEntity save);
}
