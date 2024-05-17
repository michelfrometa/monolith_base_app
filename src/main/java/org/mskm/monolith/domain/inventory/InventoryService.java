package org.mskm.monolith.domain.inventory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mskm.monolith.domain.inventory.mappings.create_inventory.CreateInventoryDto;
import org.mskm.monolith.domain.inventory.mappings.inventory.InventoryDto;
import org.mskm.monolith.domain.inventory.mappings.update_inventory.UpdateInventoryDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mskm.monolith.domain.inventory.mappings.create_inventory.CreateInventoryDtoMapper.CREATE_INVENTORY_DTO_MAPPER;
import static org.mskm.monolith.domain.inventory.mappings.inventory.InventoryDtoMapper.INVENTORY_DTO_MAPPER;
import static org.mskm.monolith.domain.inventory.mappings.update_inventory.UpdateInventoryDtoMapper.UPDATE_INVENTORY_DTO_MAPPER;


@Service
@AllArgsConstructor
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
                .map(CREATE_INVENTORY_DTO_MAPPER::toEntity)
                .flatMap(inventoryRepository::save)
                .map(INVENTORY_DTO_MAPPER::toDto);
    }

    /**
     * Retrieves a inventory by its ID.
     *
     * @param id the ID of the inventory
     * @return a Mono emitting the inventory if found, otherwise empty
     */
    public Mono<InventoryDto> getById(String id) {
        return Mono.justOrEmpty(id)
                .flatMap(inventoryRepository::findById)
                .map(INVENTORY_DTO_MAPPER::toDto);
    }

    /**
     * Retrieves all inventorys.
     *
     * @return a Flux emitting all inventorys
     */
    public Flux<InventoryDto> getAll() {
        return inventoryRepository.findAll()
                .map(INVENTORY_DTO_MAPPER::toDto);
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
                .map(INVENTORY_DTO_MAPPER::toDto);
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
