package com.shoppinglist.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AddItemRequest {
    @NotBlank
    private String itemName;
    @NotBlank
    private String itemDescription;
    @NotBlank
    @PositiveOrZero
    private BigDecimal itemPrice;
    @NotBlank
    @Min(1)
    private Long itemQuantity;
}
