package com.example.microservice.service;

import com.example.microservice.dto.ProductDto;
import com.example.microservice.dto.ResponseDto;
import com.example.microservice.model.Product;
import com.example.microservice.repository.ProductRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(long id) throws NotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product id " + id + " not found!"));
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product findProductByBrand(String brand) throws NotFoundException {
        return productRepository.findByBrand(brand).orElseThrow(() -> new NotFoundException("Product brand " + brand + " not found!"));
    }

    @Override
    public Product findProductByCategory(String category) throws NotFoundException {
        return productRepository.findByCategory(category).orElseThrow(() -> new NotFoundException("Product category " + category + " not found!"));
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productRepository.save(convertProductDtoToProduct(productDto));
        return convertProductToProductDto(product);
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
    public ResponseDto deleteProductById(Long id) {
        productRepository.deleteById(id);
        return new ResponseDto("Product id " + id + " has been deleted successfully!");
    }

    @Override
    public ProductDto convertProductToProductDto(Product product) {
        if (product.getId() != null) {
            return new ProductDto(product.getId(),product.getName(),product.getPrice(),product.getColor(),product.getBrand(),product.getCategory());
        } else
        return ProductDto.builder().name(product.getName()).price(product.getPrice()).color(product.getColor()).brand(product.getBrand()).category(product.getCategory()).build();
    }

    @Override
    public Product convertProductDtoToProduct(ProductDto productDto) {
        if (productDto.getId() != null) {
            return new Product(productDto.getId(),productDto.getName(),productDto.getPrice(),productDto.getColor(),productDto.getBrand(),productDto.getCategory());
        } else
            return Product.builder().name(productDto.getName()).price(productDto.getPrice()).color(productDto.getColor()).brand(productDto.getBrand()).category(productDto.getCategory()).build();
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
