package com.example.experiment_7.repository;

import com.example.experiment_7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}