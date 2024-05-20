package org.mskm.monolith.domain.product.mappers.product;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mskm.monolith.domain.common.mappers.EntityMapper;
import org.mskm.monolith.domain.product.entities.Product;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductDtoMapper extends EntityMapper<ProductDto, Product> {
    ProductDtoMapper PRODUCT_DTO_MAPPER = Mappers.getMapper(ProductDtoMapper.class);
}