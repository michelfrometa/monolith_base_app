package org.mskm.monolith.domain.inventory.mappers.inventory;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mskm.monolith.domain.common.mappers.EntityMapper;
import org.mskm.monolith.domain.inventory.entities.Inventory;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryDtoMapper extends EntityMapper<InventoryDto, Inventory> {
    InventoryDtoMapper INVENTORY_DTO_MAPPER = Mappers.getMapper(InventoryDtoMapper.class);
}