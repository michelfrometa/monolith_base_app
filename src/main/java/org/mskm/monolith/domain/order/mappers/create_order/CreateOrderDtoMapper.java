package org.mskm.monolith.domain.order.mappers.create_order;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mskm.monolith.domain.common.mappers.EntityMapper;
import org.mskm.monolith.domain.order.entities.Order;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreateOrderDtoMapper extends EntityMapper<CreateOrderDto, Order> {
    CreateOrderDtoMapper CREATE_ORDER_DTO_MAPPER = Mappers.getMapper(CreateOrderDtoMapper.class);
}