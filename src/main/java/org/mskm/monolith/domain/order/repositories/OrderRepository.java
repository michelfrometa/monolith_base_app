package org.mskm.monolith.domain.order.repositories;


import org.mskm.monolith.domain.order.entities.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
}
