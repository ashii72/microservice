package com.example.microservice.service;

import com.example.microservice.dto.ProductDto;
import com.example.microservice.dto.ResponseDto;
import com.example.microservice.model.Product;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Product findProductById(long id) throws NotFoundException;
    Optional<Product> findProductByName(String name);
    Product findProductByBrand(String brand) throws NotFoundException;
    Product findProductByCategory(String category) throws NotFoundException;

    ProductDto saveProduct(ProductDto productDto);
    ProductDto editProductById(ProductDto productDto);
    ResponseDto deleteProductById(Long id);

    ProductDto convertProductToProductDto(Product product);
    Product convertProductDtoToProduct(ProductDto productDto);

    List<Product> findAllProducts();
    List<Product> findAllProductsByOrderByNameAsc();
    List<Product> findAllProductsByOrderByNameDesc();
    List<Product> findAllProductsByOrderByPriceAsc();
    List<Product> findAllProductsByOrderByPriceDesc();
}
