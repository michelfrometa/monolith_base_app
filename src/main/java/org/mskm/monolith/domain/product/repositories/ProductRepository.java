package org.mskm.monolith.domain.product.repositories;

import org.mskm.monolith.domain.product.entities.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
