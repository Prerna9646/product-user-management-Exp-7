package com.example.experiment_7.DTO;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductDTO {

    private long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @Positive(message = "Price must be positive")
    private double price;

    @Min(value = 0, message = "Quantity cannot be negative")
    private int quantity;

    private String description;
}