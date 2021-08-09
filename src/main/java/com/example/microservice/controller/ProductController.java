package com.example.microservice.controller;

import com.example.microservice.dto.ProductDto;
import com.example.microservice.dto.ResponseDto;
import com.example.microservice.model.Product;
import com.example.microservice.service.ProductService;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/name")
    public Optional<Product> getByName(@RequestParam("name") String name) {
        return productService.findProductByName(name);
    }

    @GetMapping("/id/{id}")
    public Product getById(@PathVariable("id") long id) throws NotFoundException {
        return productService.findProductById(id);
    }

    @GetMapping("/brand/{brand}")
    public Product getByBrand(@PathVariable("brand") String brand) throws NotFoundException {
        return productService.findProductByBrand(brand);
    }

    @GetMapping("/category/{category}")
    public Product getByCategory(@PathVariable("category") String category) throws NotFoundException {
        return productService.findProductByCategory(category);
    }

    @PostMapping("/save")
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @PostMapping("edit/{id}")
    public ProductDto editProductById(@RequestBody ProductDto productDto) {
        return productService.editProductById(productDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteProductById(@PathVariable("id") Long id) {
        return productService.deleteProductById(id);
    }


    @GetMapping("/get-all-product")
    public List<Product> finaAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/sort/name/asc")
    public List<Product> findAllProductsByOrderByNameAsc() {
        return productService.findAllProductsByOrderByNameAsc();
    }

    @GetMapping("/sort/name/desc")
    public List<Product> findAllProductsByOrderByNameDesc() {
        return productService.findAllProductsByOrderByNameDesc();
    }

    @GetMapping("/sort/price/asc")
    public List<Product> findAllProductsByOrderByPriceAsc() {
        return productService.findAllProductsByOrderByPriceAsc();
    }

    @GetMapping("/sort/price/desc")
    public List<Product> findAllProductsByOrderByPriceDesc() {
        return productService.findAllProductsByOrderByPriceDesc();
    }
}
