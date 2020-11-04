package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        System.out.println("inside save product service ----------------- ");
        return repository.save(product);
    }

    public List<Product> saveAllProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getAllProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getAllProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProductById(int id) {
        repository.deleteById(id);
        return "Product deleted successfully" + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }
}
