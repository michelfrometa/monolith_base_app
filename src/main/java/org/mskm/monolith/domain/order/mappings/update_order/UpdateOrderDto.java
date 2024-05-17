package org.mskm.monolith.domain.order.mappings.update_order;

import org.mskm.monolith.domain.order.Order;

import java.io.Serializable;

/**
 * DTO for {@link Order}
 */
public record UpdateOrderDto(String name, double value) implements Serializable {
}