package com.shoppinglist.services;

import com.shoppinglist.DTOs.AddItemRequest;
import com.shoppinglist.DTOs.AddItemResponse;
import com.shoppinglist.data.models.Item;
import com.shoppinglist.data.repositories.ShoppingListRepository;
import com.shoppinglist.exceptions.ItemNotFoundException;
import com.shoppinglist.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingListServicesImpl implements ShoppingListServices {
    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Override
    public AddItemResponse addItem(AddItemRequest request) {
        Item item = shoppingListRepository.findByName(request.getItemName())
                .map(foundItem -> {foundItem.setQuantity(request.getItemQuantity() + foundItem.getQuantity());
                    return foundItem;})
                .orElseGet(() -> Mapper.map(request));
        shoppingListRepository.save(item);
        return Mapper.toResponse(item);
    }

    @Override
    public boolean removeItem(Long id) {
        if(shoppingListRepository.existsById(id)) {
            shoppingListRepository.deleteById(id);
            return true;
        }
        throw new ItemNotFoundException();
    }

    @Override
    public List<AddItemResponse> getItems() {
        return shoppingListRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")).stream().map(Mapper::toResponse).toList();
    }

    @Override
    public List<AddItemResponse> getPendingItems() {
        List<Item> allItems = shoppingListRepository.findAll().stream()
                .filter(item -> !(item.isActive())).toList();
        return allItems.stream().map(Mapper::toResponse).toList();
    }

    @Override
    public AddItemResponse markItemAsBought(Long id) {
        return null;
    }
}
