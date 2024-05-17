package org.mskm.monolith.domain.order.mappings.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mskm.monolith.domain.order.Order;

import java.io.Serializable;

/**
 * DTO for {@link Order}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {

    private String id;

    private String name;

    private double value;
}