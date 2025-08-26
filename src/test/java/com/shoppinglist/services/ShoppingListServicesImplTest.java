package com.shoppinglist.services;

import com.shoppinglist.DTOs.AddItemRequest;
import com.shoppinglist.DTOs.AddItemResponse;
import com.shoppinglist.data.models.Item;
import com.shoppinglist.data.repositories.ShoppingListRepository;
import com.shoppinglist.utils.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ShoppingListServicesImplTest {

    @MockitoBean
    ShoppingListRepository shoppingListRepository;

    @Autowired
    ShoppingListServicesImpl shoppingListServices;

    AddItemRequest item;
    AddItemRequest item2;

    @BeforeEach
    void setUp() {
        item = new AddItemRequest();
        item.setItemName("Item1");
        item.setItemQuantity(1L);
        item2 = new AddItemRequest();
        item2.setItemName("Item2");

    }

    @Test
    void testAddItemAddsNewItemWhenDoesNotExist() {
        when(shoppingListRepository.save(any(Item.class))).thenAnswer(i -> {
            when(shoppingListRepository.count()).thenReturn(1L);
            return i.getArguments()[0];
        });


        AddItemResponse addItemResponse = shoppingListServices.addItem(item);
        assertNotNull(addItemResponse);
        assert(shoppingListRepository.count() == 1L);
    }

    @Test
    void testThatShouldIncreaseQuantityIfItemExists() {
        Item existing = new Item();
        existing.setName("Item1");
        existing.setQuantity(1L);
        when (shoppingListRepository.findByName(any())).thenReturn(Optional.of(existing));

        item.setItemQuantity(2L);
        shoppingListServices.addItem(item);
        assertEquals(3L, existing.getQuantity());
    }



}