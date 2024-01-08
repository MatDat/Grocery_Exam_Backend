package com.example.grocery_exam.repository;
import com.example.grocery_exam.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepo extends JpaRepository<ProductOrder,Integer> {
}
