package org.mskm.monolith.domain.order.mappings.create_order;

import org.mskm.monolith.domain.order.Order;

import java.io.Serializable;

/**
 * DTO for {@link Order}
 */
public record CreateOrderDto(String name, double value) implements Serializable {
}