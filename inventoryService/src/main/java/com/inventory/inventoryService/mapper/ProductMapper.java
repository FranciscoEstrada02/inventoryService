package com.inventory.inventoryService.mapper;

import com.inventory.inventoryService.Dtos.ProductDTO;
import com.inventory.inventoryService.Dtos.ProductResponseDTO;
import com.inventory.inventoryService.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    // Mapeo de Producto a ProductoResponseDTO
    ProductResponseDTO productToProductResponseDTO(Product product);

    // Mapeo de ProductoDTO a Producto
    Product productDTOToProduct(ProductDTO productDTO);

    // Mapeo de Producto a ProductoDTO
    ProductDTO productToProductDTO(Product product);
}
