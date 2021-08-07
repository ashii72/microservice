package com.example.microservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProductTest {

    @Test
    void testProduct() {
        Product p1 = new Product(1,"mobile",1000,"white","samsung","electronics");
        Product p2 = new Product(2,"laptop",24000,"black","asus","electronics");
        Product p3 = new Product(3, "soap",30,"red","dove","health");
        Product p4 = new Product(4,"sun-glasses",567,"gray","rayban","glasses");

        List<Product> productList = List.of(p1,p2,p3,p4);

        Assertions.assertFalse(false);
        Assertions.assertEquals(4,productList.size());
    }
}