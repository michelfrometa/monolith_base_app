package org.mskm.monolith.domain.inventory.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mskm.monolith.domain.inventory.mappers.create_inventory.CreateInventoryDto;
import org.mskm.monolith.domain.inventory.mappers.create_inventory.CreateInventoryDtoMapper;
import org.mskm.monolith.domain.inventory.mappers.inventory.InventoryDto;
import org.mskm.monolith.domain.inventory.mappers.inventory.InventoryDtoMapper;
import org.mskm.monolith.domain.inventory.mappers.update_inventory.UpdateInventoryDto;
import org.mskm.monolith.domain.inventory.repositories.InventoryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mskm.monolith.domain.inventory.mappers.update_inventory.UpdateInventoryDtoMapper.UPDATE_INVENTORY_DTO_MAPPER;


@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    /**
     * Creates a new inventory.
     *
     * @param createInventoryDto the DTO containing inventory information
     * @return a Mono emitting the created inventory
     */
    public Mono<InventoryDto> create(CreateInventoryDto createInventoryDto) {
        return Mono.justOrEmpty(createInventoryDto)
                .map(CreateInventoryDtoMapper.CREATE_INVENTORY_DTO_MAPPER::toEntity)
                .flatMap(inventoryRepository::save)
                .map(InventoryDtoMapper.INVENTORY_DTO_MAPPER::toDto);
    }

    /**
     * Retrieves an inventory by its ID.
     *
     * @param id the ID of the inventory
     * @return a Mono emitting the inventory if found, otherwise empty
     */
    public Mono<InventoryDto> getById(String id) {
        return Mono.justOrEmpty(id)
                .flatMap(inventoryRepository::findById)
                .map(InventoryDtoMapper.INVENTORY_DTO_MAPPER::toDto);
    }

    /**
     * Retrieves all inventorys.
     *
     * @return a Flux emitting all inventorys
     */
    public Flux<InventoryDto> getAll() {
        return inventoryRepository.findAll()
                .map(InventoryDtoMapper.INVENTORY_DTO_MAPPER::toDto);
    }

    /**
     * Updates an existing inventory.
     *
     * @param id                 the ID of the inventory to update
     * @param updateInventoryDto the DTO containing updated inventory information
     * @return a Mono emitting the updated inventory
     */
    public Mono<InventoryDto> update(String id, UpdateInventoryDto updateInventoryDto) {
        return Mono.justOrEmpty(id)
                .flatMap(inventoryRepository::findById)
                .map(entity -> UPDATE_INVENTORY_DTO_MAPPER.partialUpdate(entity, updateInventoryDto))
                .flatMap(inventoryRepository::save)
                .map(InventoryDtoMapper.INVENTORY_DTO_MAPPER::toDto);
    }

    /**
     * Deletes a inventory by its ID.
     *
     * @param id the ID of the inventory to delete
     * @return a Mono completing when the deletion is done
     */
    public Mono<Void> delete(String id) {
        return inventoryRepository.deleteById(id);
    }

    /**
     * Deletes all inventorys in the repository.
     *
     * @return a Mono completing when all inventorys are deleted
     */
    public Mono<Void> deleteAll() {
        return inventoryRepository.deleteAll();
    }
}
