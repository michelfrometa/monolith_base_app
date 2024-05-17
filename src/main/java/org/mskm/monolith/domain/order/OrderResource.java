package org.mskm.monolith.domain.order;

import lombok.AllArgsConstructor;
import org.mskm.monolith.domain.order.mappings.create_order.CreateOrderDto;
import org.mskm.monolith.domain.order.mappings.order.OrderDto;
import org.mskm.monolith.domain.order.mappings.update_order.UpdateOrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderResource {
    private final OrderService orderService;

    @GetMapping
    public Flux<OrderDto> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OrderDto> createOrder(@RequestBody CreateOrderDto order) {
        return orderService.create(order);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<OrderDto>> getOrderById(@PathVariable("id") String id) {
        return orderService.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<OrderDto>> updateOrder(@PathVariable("id") String id,
                                                      @RequestBody UpdateOrderDto order) {
        return orderService.update(id, order)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteOrder(@PathVariable("id") String id) {
        return orderService.delete(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllOrder() {
        return orderService.deleteAll();
    }

}
