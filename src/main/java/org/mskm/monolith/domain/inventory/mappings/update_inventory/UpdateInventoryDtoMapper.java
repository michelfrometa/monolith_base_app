package org.mskm.monolith.domain.inventory.mappings.update_inventory;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mskm.monolith.common.mappings.EntityMapper;
import org.mskm.monolith.domain.inventory.Inventory;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UpdateInventoryDtoMapper extends EntityMapper<UpdateInventoryDto, Inventory> {
    UpdateInventoryDtoMapper UPDATE_INVENTORY_DTO_MAPPER = Mappers.getMapper(UpdateInventoryDtoMapper.class);
}