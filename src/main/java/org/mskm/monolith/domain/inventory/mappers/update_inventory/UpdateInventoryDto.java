package org.mskm.monolith.domain.inventory.mappers.update_inventory;


import org.mskm.monolith.domain.inventory.entities.Inventory;

import java.io.Serializable;

/**
 * DTO for {@link Inventory}
 */
public record UpdateInventoryDto(String name, double value) implements Serializable {
}