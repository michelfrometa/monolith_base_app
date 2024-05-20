package org.mskm.monolith.domain.order.mappers.create_order;

import org.mskm.monolith.domain.order.entities.Order;

import java.io.Serializable;

/**
 * DTO for {@link Order}
 */
public record CreateOrderDto(String name, double value) implements Serializable {
}