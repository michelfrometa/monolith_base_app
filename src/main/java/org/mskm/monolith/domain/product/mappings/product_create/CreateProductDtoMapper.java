package org.mskm.monolith.domain.product.mappings.product_create;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mskm.monolith.common.mappings.EntityMapper;
import org.mskm.monolith.domain.product.Product;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreateProductDtoMapper extends EntityMapper<CreateProductDto, Product> {
    CreateProductDtoMapper CREATE_PRODUCT_DTO_MAPPER = Mappers.getMapper(CreateProductDtoMapper.class);
}