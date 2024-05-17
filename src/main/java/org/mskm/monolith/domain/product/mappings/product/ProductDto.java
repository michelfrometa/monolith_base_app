package org.mskm.monolith.domain.product.mappings.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mskm.monolith.domain.product.Product;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    private String id;

    private String name;

    private double value;
}