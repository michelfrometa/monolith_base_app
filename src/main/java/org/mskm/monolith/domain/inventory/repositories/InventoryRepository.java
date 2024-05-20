package org.mskm.monolith.domain.inventory.repositories;

import org.mskm.monolith.domain.inventory.entities.Inventory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends ReactiveMongoRepository<Inventory, String> {
}
