package com.shoppinglist.services;

import com.shoppinglist.DTOs.AddItemRequest;
import com.shoppinglist.DTOs.AddItemResponse;

import java.util.List;

public interface ShoppingListServices {

    AddItemResponse addItem(AddItemRequest request);
    boolean removeItem(Long id);
    List<AddItemResponse> getItems();
    List<AddItemResponse> getPendingItems();
    AddItemResponse markItemAsBought(Long id);
}
