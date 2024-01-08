package com.example.grocery_exam.service;

import com.example.grocery_exam.model.Product;
import com.example.grocery_exam.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public ResponseEntity<Product> saveProduct(Product product) {
        productRepo.save(product);
        return ResponseEntity.ok(product);
    }


}
