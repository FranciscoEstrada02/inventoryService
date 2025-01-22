package com.inventory.inventoryService.Dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {

    @NotNull
    private String name;

    private String description;

    private double price;

    private int stock;

    private String category;
}
