package com.inventory.inventoryService.service;

import com.inventory.inventoryService.Dtos.ProductDTO;
import com.inventory.inventoryService.Dtos.ProductResponseDTO;
import com.inventory.inventoryService.mapper.ProductMapper;
import com.inventory.inventoryService.model.Product;
import com.inventory.inventoryService.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }



    public List<ProductResponseDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }
    public ProductResponseDTO  getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(productMapper::productToProductResponseDTO).orElse(null);
    }
    public ProductResponseDTO  createProduct(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductResponseDTO(savedProduct);
    }

    public ProductResponseDTO updateProduct(Long id, ProductDTO productDTO) {
        if (productRepository.existsById(id)) {
            Product product = productMapper.productDTOToProduct(productDTO);
            product.setId(id);
            Product updatedProduct = productRepository.save(product);
            return productMapper.productToProductResponseDTO(updatedProduct);
        }
        return null;
    }

}
