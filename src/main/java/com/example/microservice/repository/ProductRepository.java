package com.example.microservice.repository;

import com.example.microservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
    Optional<Product> findByBrand(String brand);
    Optional<Product> findByCategory(String category);

    List<Product> findAllByOrderByNameAsc();
    List<Product> findAllByOrderByNameDesc();
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
}
