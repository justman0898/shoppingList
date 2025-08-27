package com.shoppinglist.controllers;

import com.shoppinglist.DTOs.AddItemResponse;
import com.shoppinglist.services.ShoppingListServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = { ShoppingListController.class })
class ShoppingListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ShoppingListServices shoppingListServices;

    private AddItemResponse itemResponse;
    private AddItemResponse itemResponse2;

    @BeforeEach
    void setUp() {
        itemResponse = new AddItemResponse();
        itemResponse.setId(1L);
        itemResponse.setName("item1");
    }

    @Test
    void testCanGetPendingItems() throws Exception {
        when(shoppingListServices.getPendingItems()).thenReturn(List.of(itemResponse));

        mockMvc.perform(get("/items/pending"))
                .andExpect(status().isOk())
                .andExpect(view().name("items/pending"));


    }

}