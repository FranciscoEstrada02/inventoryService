package com.inventory.inventoryService.controller;

import com.inventory.inventoryService.Dtos.ProductDTO;
import com.inventory.inventoryService.Dtos.ProductResponseDTO;
import com.inventory.inventoryService.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id){
        ProductResponseDTO productResponseDTO = productService.getProduct(id);
        if(productResponseDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductResponseDTO createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductResponseDTO updatedProduct = productService.updateProduct(id, productDTO);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build(); // Return 404 if product is not found
        }
        return ResponseEntity.ok(updatedProduct); // Return 200 OK if the product is updated
    }


}
