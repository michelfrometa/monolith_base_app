package org.mskm.monolith.domain.product.mappings.product_create;

import org.mskm.monolith.domain.product.Product;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
public record CreateProductDto(String name, double value) implements Serializable {
}