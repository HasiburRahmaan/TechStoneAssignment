package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/post/product")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @GetMapping("/get/product/all")
    public List<Product> getAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/get/product/{id}")
    public  Product getProductById(@PathVariable Integer id){
        return  service.findById(id);
    }
}
