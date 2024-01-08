package com.example.grocery_exam.restController;

import com.example.grocery_exam.model.Product;
import com.example.grocery_exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

//    @PostMapping("/addProduct")
//    public ResponseEntity<AppointmentDTO> addProduct(@RequestBody AppointmentDTO appointmentDTO){
//        ResponseEntity<AppointmentDTO> saveAppointment = appointmentService.save(appointmentDTO);
//
//        return x;
//    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/findProductByName/{name}")
    public ResponseEntity<Product> findProductByName(@PathVariable("name") String name){
        return productService.findByName(name);
    }
}
