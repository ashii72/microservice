package com.example.microservice.controller;

import com.example.microservice.dto.ProductDto;
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
        return productService.findProductById(id).orElseThrow(() -> new NotFoundException("Product id " + id + " not found!"));
    }

    @GetMapping("/brand/{brand}")
    public Product getByBrand(@PathVariable("brand") String brand) throws NotFoundException {
        return productService.findProductByBrand(brand).orElseThrow(() -> new NotFoundException("Product brand " + brand + " not found!"));
    }

    @GetMapping("/category/{category}")
    public Product getByCategory(@PathVariable("category") String category) throws NotFoundException {
        return productService.findProductByCategory(category).orElseThrow(() -> new NotFoundException("Product category " + category + " not found!"));
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(new Product());
    }

    @PostMapping("edit/{id}")
    public ProductDto editProductById(@RequestBody ProductDto productDto) {
        return productService.editProductById(productDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable("id") long id) {
        productService.deleteProductById(id);
    }


    @GetMapping("/list")
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
