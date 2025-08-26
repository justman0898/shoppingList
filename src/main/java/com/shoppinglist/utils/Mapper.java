package com.shoppinglist.utils;

import com.shoppinglist.DTOs.AddItemRequest;
import com.shoppinglist.DTOs.AddItemResponse;
import com.shoppinglist.data.models.Item;

public class Mapper {

    public static Item map(AddItemRequest addItemRequest) {
        Item addedItem = new Item();
        addedItem.setName(addItemRequest.getItemName());
        addedItem.setDescription(addItemRequest.getItemDescription());
        addedItem.setPrice(addItemRequest.getItemPrice());
        addedItem.setQuantity(addItemRequest.getItemQuantity());
        return addedItem;
    }

    public static AddItemResponse toResponse(Item addedItem) {
        AddItemResponse response = new AddItemResponse();
        response.setId(addedItem.getId());
        response.setName(addedItem.getName());
        response.setDescription(addedItem.getDescription());
        response.setPrice(addedItem.getPrice());
        response.setQuantity(addedItem.getQuantity());
        response.setActive(addedItem.isActive());
        response.setCreatedAt(addedItem.getCreatedAt());
        return response;
    }
}
