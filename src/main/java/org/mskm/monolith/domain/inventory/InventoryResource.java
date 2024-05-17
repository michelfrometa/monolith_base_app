package org.mskm.monolith.domain.inventory;

import lombok.AllArgsConstructor;
import org.mskm.monolith.domain.inventory.mappings.create_inventory.CreateInventoryDto;
import org.mskm.monolith.domain.inventory.mappings.inventory.InventoryDto;
import org.mskm.monolith.domain.inventory.mappings.update_inventory.UpdateInventoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@AllArgsConstructor
@RequestMapping("/inventories")
public class InventoryResource {
    private final InventoryService inventoryService;

    @GetMapping
    public Flux<InventoryDto> getAllInventories() {
        return inventoryService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<InventoryDto> createInventory(@RequestBody CreateInventoryDto inventory) {
        return inventoryService.create(inventory);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<InventoryDto>> getInventoryById(@PathVariable("id") String id) {
        return inventoryService.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<InventoryDto>> updateInventory(@PathVariable("id") String id,
                                                              @RequestBody UpdateInventoryDto inventory) {
        return inventoryService.update(id, inventory)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteInventory(@PathVariable("id") String id) {
        return inventoryService.delete(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllInventory() {
        return inventoryService.deleteAll();
    }

}
