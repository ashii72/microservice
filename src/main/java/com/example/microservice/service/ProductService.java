package com.example.microservice.service;

import com.example.microservice.dto.ProductDto;
import com.example.microservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Optional<Product> findProductById(long id);
    Optional<Product> findProductByName(String name);
    Optional<Product> findProductByBrand(String brand);
    Optional<Product> findProductByCategory(String category);

    Product saveProduct(Product product);
    ProductDto editProductById(ProductDto productDto);
    void deleteProductById(long id);

    ProductDto convertProductToProductDto(Product product);
    Optional<Product> convertProductDtoToProduct(ProductDto productDto);

    List<Product> findAllProducts();
    List<Product> findAllProductsByOrderByNameAsc();
    List<Product> findAllProductsByOrderByNameDesc();
    List<Product> findAllProductsByOrderByPriceAsc();
    List<Product> findAllProductsByOrderByPriceDesc();
}
