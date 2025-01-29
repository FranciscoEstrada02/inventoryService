package com.inventory.inventoryService.mapper;

import com.inventory.inventoryService.Dtos.ProductDTO;
import com.inventory.inventoryService.Dtos.ProductResponseDTO;
import com.inventory.inventoryService.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // Mapeo de ProductDTO a Product
    Product productDTOToProduct(ProductDTO productDTO);

    // Mapeo de Product a ProductResponseDTO
    ProductResponseDTO productToProductResponseDTO(Product product);

    // Mapeo de Product a ProductDTO
    ProductDTO productToProductDTO(Product product);
}
