package org.mskm.monolith.domain.inventory.mappers.create_inventory;

import org.mskm.monolith.domain.inventory.entities.Inventory;

import java.io.Serializable;

/**
 * DTO for {@link Inventory}
 */
public record CreateInventoryDto(String name, double value) implements Serializable {
}