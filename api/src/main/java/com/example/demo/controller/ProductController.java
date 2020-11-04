package com.example.demo.controller;

//import com.example.crud.entity.Product;
//import com.example.crud.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        System.out.println("Inside addProducts controller --------------------------");
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveAllProducts(products);

    }

    @GetMapping("/allProducts")
    public List<Product> findAllProducts() {
        System.out.println("Inside all Products controller --------------------------");

        return service.getAllProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getAllProductById(id);
    }

    //    @GetMapping("/productByName/{name}")
//    public List<Product> findProductByName(@PathVariable String name){
//        return service.getAllProductByName(name);
//    }
    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getAllProductByName(name);
    }

    @PutMapping("/updateProduct")
    public Product update(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/deleteById/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteProductById(id);

    }
}
