package org.mskm.monolith.domain.inventory.mappers.update_inventory;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mskm.monolith.domain.common.mappers.EntityMapper;
import org.mskm.monolith.domain.inventory.entities.Inventory;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UpdateInventoryDtoMapper extends EntityMapper<UpdateInventoryDto, Inventory> {
    UpdateInventoryDtoMapper UPDATE_INVENTORY_DTO_MAPPER = Mappers.getMapper(UpdateInventoryDtoMapper.class);
}