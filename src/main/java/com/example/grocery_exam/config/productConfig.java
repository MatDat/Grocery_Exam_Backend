package com.example.grocery_exam.config;

import com.example.grocery_exam.model.Product;
import com.example.grocery_exam.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class productConfig implements CommandLineRunner {

    @Autowired
    ProductRepo productRepo;
    @Override
    public void run(String... args) throws Exception {
        Product tofu = new Product();
        tofu.setName("Tofu");
        tofu.setWeight(8.3);
        tofu.setPrice(22.5);

        Product egg = new Product();
        egg.setName("Egg");
        egg.setWeight(2.6);
        egg.setPrice(2);

        Product coffee = new Product();
        coffee.setName("Coffee");
        coffee.setWeight(10);
        coffee.setPrice(69.99);

        productRepo.save(tofu);
        productRepo.save(egg);
        productRepo.save(coffee);
    }
}
