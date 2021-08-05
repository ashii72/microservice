package com.example.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Long price;
    private String color;
    private String brand;
    private String category;
}
