package org.mskm.monolith.domain.order.mappings.order;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mskm.monolith.common.mappings.EntityMapper;
import org.mskm.monolith.domain.order.Order;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderDtoMapper extends EntityMapper<OrderDto, Order> {
    OrderDtoMapper ORDER_DTO_MAPPER = Mappers.getMapper(OrderDtoMapper.class);
}