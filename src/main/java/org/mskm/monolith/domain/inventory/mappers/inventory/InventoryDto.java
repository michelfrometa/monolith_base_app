package org.mskm.monolith.domain.inventory.mappers.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mskm.monolith.domain.inventory.entities.Inventory;

import java.io.Serializable;

/**
 * DTO for {@link Inventory}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto implements Serializable {

    private String id;

    private String name;

    private double value;
}