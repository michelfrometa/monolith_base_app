package org.mskm.monolith.domain.order.mappers.update_order;

import org.mskm.monolith.domain.order.entities.Order;

import java.io.Serializable;

/**
 * DTO for {@link Order}
 */
public record UpdateOrderDto(String name, double value) implements Serializable {
}