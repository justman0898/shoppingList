package com.shoppinglist.controllers;

import com.shoppinglist.DTOs.AddItemRequest;
import com.shoppinglist.DTOs.AddItemResponse;
import com.shoppinglist.services.ShoppingListServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

        itemResponse2 = new AddItemResponse();
        itemResponse2.setId(2L);
    }

    @Test
    void testCanGetPendingItems() throws Exception {
        when(shoppingListServices.getPendingItems()).thenReturn(List.of(itemResponse));

        mockMvc.perform(get("/items/pending"))
                .andExpect(status().isOk())
                .andExpect(view().name("items/pending"))
                .andExpect(model().attributeExists("items"));
    }

    @Test
    void testThatCanAddItemAndRedirect() throws Exception {
        mockMvc.perform(post("/items/add")
                .param("itemName", "Milk")
                .param("itemPrice", "100")
                .param("itemQuantity", "1")
                .param("itemDescription", "10g of Milk"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/pending"));

        verify(shoppingListServices).addItem(any(AddItemRequest.class));
    }

    @Test
    void testShouldShowAddForm()throws Exception {
        mockMvc.perform(get("/items/add"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("item"))
                .andExpect(view().name("items/add"));

    }

    @Test
    void testThatShouldReturnFormWhenValidationFails() throws Exception {
        mockMvc.perform(post("/items/add")
                .param("itemName", "")
                .param("itemPrice", "-1")
                .param("itemQuantity", "0")
                .param("itemDescription", (String) null))
                .andExpect(status().isOk());
    }

    @Test
    void testThatCanMarkItemAsBought() throws Exception {
        when(shoppingListServices.getPendingItems()).thenReturn(List.of(itemResponse));
        mockMvc.perform(post("/items/1/buy"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/items/pending"));
        verify(shoppingListServices).markItemAsBought(1L);

    }



}