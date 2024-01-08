package com.example.grocery_exam.service;

import com.example.grocery_exam.model.Product;
import com.example.grocery_exam.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public ResponseEntity<Product> saveProduct(Product product) {
        productRepo.save(product);
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productRepo.findAll());
    }

    public ResponseEntity<Product> findByName(String name) {
        Optional<Product> optionalProduct = Optional.ofNullable(productRepo.findByName(name));
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
