package com.isabella.springdata.product;

import com.isabella.springdata.product.entities.Product;
import com.isabella.springdata.product.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductdataApplicationTests {

    @Autowired
    ProductRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreate() {
        Product product = new Product();
        product.setId(1);
        product.setName("S22");
        product.setDesc("Awesome");
        product.setPrice(1000d);

        repository.save(product);
    }

    @Test
    public void testRead() {
        Product product = repository.findById(1).get();
        assertNotNull(product);
        assertEquals("S22", product.getName());
    }

    @Test
    public void testUpdate() {
        Product product = repository.findById(1).get();
        product.setPrice(1200d);
        repository.save(product);
    }

    @Test
    public void testDelete() {
        Product product = repository.findById(1).get();
        repository.delete(product);
        }
        /*
        or
        if (repository.exists(1)){
            repository.delete(1);
        }
         */

    @Test
    public void testCount() {
        System.out.println("Total records: " + repository.count());
    }

    @Test
    public void testFindByName() {
        List<Product> products = repository.findByName("IWatch");
        products.forEach(p->System.out.println(p.getPrice()));
    }

    @Test
    public void testFindByNameAndDesc() {
        List<Product> products = repository.findByNameAndDesc("IWatch", "From Apple Inc");
        products.forEach(p->System.out.println(p.getPrice()));
    }

    @Test
    public void testFindByPriceGreaterThan() {
        List<Product> products = repository.findByPriceGreaterThan(700d);
        products.forEach(p->System.out.println(p.getPrice()));
    }

    @Test
    public void testFindByDescContains() {
        List<Product> products = repository.findByDescContains("Apple");
        products.forEach(p->System.out.println(p.getName()));
    }

    @Test
    public void testFindByPriceBetween() {
        List<Product> products = repository.findByPriceBetween(1000d, 2000d);
        products.forEach(p->System.out.println(p.getPrice()));
    }

    @Test
    public void testFindByDescLike() {
        List<Product> products = repository.findByDescLike("%Dyson%");
        products.forEach(p->System.out.println(p.getName()));
    }

    @Test
    public void testFindByIdIn() {
        List<Product> products = repository.findByIdIn(Arrays.asList(1,3));
        products.forEach(p->System.out.println(p.getName()));
    }
}
