package com.isabella.springdata.product.repos;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.isabella.springdata.product.entities.Product;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findByName(String name);
    List<Product> findByNameAndDesc(String name, String desc);
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByDescContains(String desc);
    List<Product> findByPriceBetween(Double price1, Double price2); // <=
    List<Product> findByDescLike(String desc);
    List<Product> findByIdIn(List<Integer> ids, Pageable pageable);
}
