package com.example.spring.exception.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemRequest {
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

}

