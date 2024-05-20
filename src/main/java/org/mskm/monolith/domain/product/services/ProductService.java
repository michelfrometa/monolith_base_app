package org.mskm.monolith.domain.product.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mskm.monolith.domain.product.mappers.product.ProductDto;
import org.mskm.monolith.domain.product.mappers.product_create.CreateProductDto;
import org.mskm.monolith.domain.product.mappers.product_create.CreateProductDtoMapper;
import org.mskm.monolith.domain.product.mappers.product_update.UpdateProductDto;
import org.mskm.monolith.domain.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mskm.monolith.domain.product.mappers.product.ProductDtoMapper.PRODUCT_DTO_MAPPER;
import static org.mskm.monolith.domain.product.mappers.product_update.UpdateProductDtoMapper.UPDATE_PRODUCT_DTO_MAPPER;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * Creates a new product.
     *
     * @param createProductDto the DTO containing product information
     * @return a Mono emitting the created product
     */
    public Mono<ProductDto> create(CreateProductDto createProductDto) {
        return Mono.justOrEmpty(createProductDto)
                .map(CreateProductDtoMapper.CREATE_PRODUCT_DTO_MAPPER::toEntity)
                .flatMap(productRepository::save)
                .map(PRODUCT_DTO_MAPPER::toDto);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return a Mono emitting the product if found, otherwise empty
     */
    public Mono<ProductDto> getById(String id) {
        return Mono.justOrEmpty(id)
                .flatMap(productRepository::findById)
                .map(PRODUCT_DTO_MAPPER::toDto);
    }

    /**
     * Retrieves all products.
     *
     * @return a Flux emitting all products
     */
    public Flux<ProductDto> getAll() {
        return productRepository.findAll()
                .map(PRODUCT_DTO_MAPPER::toDto);
    }

    /**
     * Updates an existing product.
     *
     * @param id               the ID of the product to update
     * @param updateProductDto the DTO containing updated product information
     * @return a Mono emitting the updated product
     */
    public Mono<ProductDto> update(String id, UpdateProductDto updateProductDto) {
        return Mono.justOrEmpty(id)
                .flatMap(productRepository::findById)
                .map(entity -> UPDATE_PRODUCT_DTO_MAPPER.partialUpdate(entity, updateProductDto))
                .flatMap(productRepository::save)
                .map(PRODUCT_DTO_MAPPER::toDto);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return a Mono completing when the deletion is done
     */
    public Mono<Void> delete(String id) {
        return productRepository.deleteById(id);
    }

    /**
     * Deletes all products in the repository.
     *
     * @return a Mono completing when all products are deleted
     */
    public Mono<Void> deleteAll() {
        return productRepository.deleteAll();
    }
}
