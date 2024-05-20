package org.mskm.monolith.domain.inventory.mappers.create_inventory;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mskm.monolith.domain.common.mappers.EntityMapper;
import org.mskm.monolith.domain.inventory.entities.Inventory;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreateInventoryDtoMapper extends EntityMapper<CreateInventoryDto, Inventory> {
    CreateInventoryDtoMapper CREATE_INVENTORY_DTO_MAPPER = Mappers.getMapper(CreateInventoryDtoMapper.class);
}