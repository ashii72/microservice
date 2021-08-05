package com.example.microservice.service;

import com.example.microservice.dto.ProductDto;
import com.example.microservice.model.Product;
import com.example.microservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    Product p1 = new Product(1,"mobile",1000,"white","samsung","electronics");
    Product p2 = new Product(2,"laptop",24000,"black","asus","electronics");
    Product p3 = new Product(3, "soap",30,"red","dove","health");
    Product p4 = new Product(4,"sun-glasses",567,"gray","rayban","glasses");

    List<Product> productList = List.of(p1,p2,p3,p4);

    @Override
    public Optional<Product> findProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product> findProductByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public Optional<Product> findProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public ProductDto editProductById(ProductDto productDto) {
        if (productDto.getId() != null) {
            var foundProduct = productRepository.findById(productDto.getId());
            if (foundProduct.isPresent()) {
                foundProduct.get().setName(productDto.getName());
                foundProduct.get().setPrice(productDto.getPrice());
                foundProduct.get().setColor(productDto.getColor());
                foundProduct.get().setBrand(productDto.getBrand());
                foundProduct.get().setCategory(productDto.getCategory());
                var updatedProduct = productRepository.save(foundProduct.get());
                return convertProductToProductDto(updatedProduct);
            }
        }
        return productDto;
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto convertProductToProductDto(Product product) {
        return new ProductDto(product.getId(),product.getName(),product.getPrice(),product.getColor(),product.getBrand(),product.getCategory());
    }

    @Override
    public Optional<Product> convertProductDtoToProduct(ProductDto productDto) {
        return productRepository.findById(productDto.getId());
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllProductsByOrderByNameAsc() {
        return productRepository.findAllByOrderByNameAsc();
    }

    @Override
    public List<Product> findAllProductsByOrderByNameDesc() {
        return productRepository.findAllByOrderByNameDesc();
    }

    @Override
    public List<Product> findAllProductsByOrderByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Product> findAllProductsByOrderByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }
}
