package com.shoppinglist.DTOs;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AddItemRequest {
    @NotNull
    @NotBlank
    @NotEmpty
    private String itemName;
    @NotBlank
    @NotNull
    private String itemDescription;
    @NotNull
    @PositiveOrZero
    private BigDecimal itemPrice;
    @NotNull
    @Min(1)
    private Long itemQuantity;
}
