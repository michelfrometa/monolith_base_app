package org.mskm.monolith.domain.order;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
}
