package com.example.grocery_exam.repository;

import com.example.grocery_exam.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Integer> {


}
