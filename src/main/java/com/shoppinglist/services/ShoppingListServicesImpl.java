package com.shoppinglist.services;

import com.shoppinglist.DTOs.AddItemRequest;
import com.shoppinglist.DTOs.AddItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListServicesImpl implements ShoppingListServices {
    @Override
    public AddItemResponse addItem(AddItemRequest request) {
        return null;
    }

    @Override
    public boolean removeItem(Long id) {
        return false;
    }

    @Override
    public List<AddItemResponse> getItems() {
        return List.of();
    }

    @Override
    public List<AddItemResponse> getPendingItems() {
        return List.of();
    }

    @Override
    public AddItemResponse markItemAsBought(Long id) {
        return null;
    }
}
