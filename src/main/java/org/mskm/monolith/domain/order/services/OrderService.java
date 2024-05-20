package org.mskm.monolith.domain.order.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mskm.monolith.domain.order.mappers.create_order.CreateOrderDto;
import org.mskm.monolith.domain.order.mappers.create_order.CreateOrderDtoMapper;
import org.mskm.monolith.domain.order.mappers.order.OrderDto;
import org.mskm.monolith.domain.order.mappers.update_order.UpdateOrderDto;
import org.mskm.monolith.domain.order.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mskm.monolith.domain.order.mappers.order.OrderDtoMapper.ORDER_DTO_MAPPER;
import static org.mskm.monolith.domain.order.mappers.update_order.UpdateOrderDtoMapper.UPDATE_ORDER_DTO_MAPPER;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    /**
     * Creates a new order.
     *
     * @param createOrderDto the DTO containing order information
     * @return a Mono emitting the created order
     */
    public Mono<OrderDto> create(CreateOrderDto createOrderDto) {
        return Mono.justOrEmpty(createOrderDto)
                .map(CreateOrderDtoMapper.CREATE_ORDER_DTO_MAPPER::toEntity)
                .flatMap(orderRepository::save)
                .map(ORDER_DTO_MAPPER::toDto);
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param id the ID of the order
     * @return a Mono emitting the order if found, otherwise empty
     */
    public Mono<OrderDto> getById(String id) {
        return Mono.justOrEmpty(id)
                .flatMap(orderRepository::findById)
                .map(ORDER_DTO_MAPPER::toDto);
    }

    /**
     * Retrieves all orders.
     *
     * @return a Flux emitting all orders
     */
    public Flux<OrderDto> getAll() {
        return orderRepository.findAll()
                .map(ORDER_DTO_MAPPER::toDto);
    }

    /**
     * Updates an existing order.
     *
     * @param id             the ID of the order to update
     * @param updateOrderDto the DTO containing updated order information
     * @return a Mono emitting the updated order
     */
    public Mono<OrderDto> update(String id, UpdateOrderDto updateOrderDto) {
        return Mono.justOrEmpty(id)
                .flatMap(orderRepository::findById)
                .map(entity -> UPDATE_ORDER_DTO_MAPPER.partialUpdate(entity, updateOrderDto))
                .flatMap(orderRepository::save)
                .map(ORDER_DTO_MAPPER::toDto);
    }

    /**
     * Deletes an order by its ID.
     *
     * @param id the ID of the order to delete
     * @return a Mono completing when the deletion is done
     */
    public Mono<Void> delete(String id) {
        return orderRepository.deleteById(id);
    }

    /**
     * Deletes all orders in the repository.
     *
     * @return a Mono completing when all orders are deleted
     */
    public Mono<Void> deleteAll() {
        return orderRepository.deleteAll();
    }
}
