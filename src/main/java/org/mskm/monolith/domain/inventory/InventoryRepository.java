package org.mskm.monolith.domain.inventory;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface InventoryRepository extends ReactiveMongoRepository<Inventory, String> {
}
