package com.shoppinglist.DTOs;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class AddItemResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private boolean status;
    private Date createdAt = Date.valueOf(LocalDate.now());
}
