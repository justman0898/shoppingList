package com.shoppinglist.services;

import com.shoppinglist.DTOs.AddItemRequest;
import com.shoppinglist.DTOs.AddItemResponse;
import com.shoppinglist.data.models.Item;
import com.shoppinglist.data.repositories.ShoppingListRepository;
import com.shoppinglist.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListServicesImpl implements ShoppingListServices {
    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Override
    public AddItemResponse addItem(AddItemRequest request) {
        Item item = shoppingListRepository.findByName(request.getItemName())
                .map(foundItem -> {
                    foundItem.setQuantity(request.getItemQuantity()+foundItem.getQuantity());
                    return foundItem;
                }).orElseGet(() -> Mapper.map(request));
        shoppingListRepository.save(item);
        return Mapper.toResponse(item);
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
