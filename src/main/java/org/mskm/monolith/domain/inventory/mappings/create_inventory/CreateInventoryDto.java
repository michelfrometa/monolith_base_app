package org.mskm.monolith.domain.inventory.mappings.create_inventory;


import org.mskm.monolith.domain.inventory.Inventory;

import java.io.Serializable;

/**
 * DTO for {@link Inventory}
 */
public record CreateInventoryDto(String name, double value) implements Serializable {
}