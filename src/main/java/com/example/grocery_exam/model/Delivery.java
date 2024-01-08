package com.example.grocery_exam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private int deliveryId;

    @Column(name = "delivery_date", nullable = false)
    private Date deliveryDate;

    @Column(name = "from_warehouse", nullable = false)
    private String fromWarehouse;

    @Column(name = "destination", nullable = false)
    private String destination;
}
