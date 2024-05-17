package org.mskm.monolith.domain.order.mappings.update_order;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mskm.monolith.common.mappings.EntityMapper;
import org.mskm.monolith.domain.order.Order;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UpdateOrderDtoMapper extends EntityMapper<UpdateOrderDto, Order> {
    UpdateOrderDtoMapper UPDATE_ORDER_DTO_MAPPER = Mappers.getMapper(UpdateOrderDtoMapper.class);
}