package com.example.experiment_7.conroller;


import com.example.experiment_7.DTO.ProductDTO;
import com.example.experiment_7.model.Product;
import com.example.experiment_7.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // CREATE
    @PostMapping("/add")
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO dto) {
        Product product = mapToEntity(dto);
        Product saved = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDTO(saved));
    }

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> list = productRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);

        return product.map(value -> ResponseEntity.ok(mapToDTO(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable long id,
                                                    @Valid @RequestBody ProductDTO dto) {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            product.setName(dto.getName());
            product.setPrice(dto.getPrice());
            product.setQuantity(dto.getQuantity());
            product.setDescription(dto.getDescription());

            Product updated = productRepository.save(product);
            return ResponseEntity.ok(mapToDTO(updated));
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {

        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    private Product mapToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setDescription(dto.getDescription());
        return product;
    }

    private ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setDescription(product.getDescription());
        return dto;
    }
}