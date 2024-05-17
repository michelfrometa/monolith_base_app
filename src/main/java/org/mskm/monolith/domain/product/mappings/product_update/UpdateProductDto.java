package org.mskm.monolith.domain.product.mappings.product_update;

import org.mskm.monolith.domain.product.Product;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
public record UpdateProductDto(String name, double value) implements Serializable {
}