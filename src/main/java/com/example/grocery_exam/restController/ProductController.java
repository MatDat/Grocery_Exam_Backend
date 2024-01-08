package com.example.grocery_exam.restController;

import com.example.grocery_exam.model.Product;
import com.example.grocery_exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
