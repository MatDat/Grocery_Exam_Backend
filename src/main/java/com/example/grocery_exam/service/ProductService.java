package com.example.grocery_exam.service;

import com.example.grocery_exam.model.Product;
import com.example.grocery_exam.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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

    public ResponseEntity<List<Product>> getAllProducts() {
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

    public ResponseEntity<Product> editProduct(Product product) {
        Optional<Product> oldProduct = productRepo.findById(product.getProductId());

        if (oldProduct.isEmpty()) {
            return ResponseEntity.notFound().build();

        }
        Product productToUpdate = oldProduct.get();

        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setWeight(product.getWeight());

//        Product updatedProduct = productRepo.save(productToUpdate);

        return ResponseEntity.ok(productRepo.save(productToUpdate));
    }

    public ResponseEntity<String> deleteProductByName(String name) {
        Optional<Product> productToDelete = Optional.ofNullable(productRepo.findByName(name));
        if (productToDelete.isPresent()) {
            productRepo.delete(productToDelete.get());
            return ResponseEntity.ok("Product '" + name + "' deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product '" + name + "' not found");
    }
}
