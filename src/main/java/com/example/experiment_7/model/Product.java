package com.example.experiment_7.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_table")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    private String description;
}