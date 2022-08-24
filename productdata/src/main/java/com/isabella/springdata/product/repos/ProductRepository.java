package com.isabella.springdata.product.repos;

import com.isabella.springdata.product.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
