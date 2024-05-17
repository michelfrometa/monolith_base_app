package org.mskm.monolith.domain.inventory.mappings.update_inventory;

import org.mskm.monolith.domain.inventory.Inventory;

import java.io.Serializable;

/**
 * DTO for {@link Inventory}
 */
public record UpdateInventoryDto(String name, double value) implements Serializable {
}