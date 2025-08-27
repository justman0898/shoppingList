package com.shoppinglist.controllers;

import com.shoppinglist.DTOs.AddItemRequest;
import jakarta.validation.Valid;
import org.springframework.ui.Model;

import com.shoppinglist.services.ShoppingListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/items")
public class ShoppingListController {

    @Autowired
    private ShoppingListServices shoppingListServices;

    @GetMapping("/pending")
    public String getPendingItems(Model model) {
        model.addAttribute("items", shoppingListServices.getPendingItems());
        return "items/pending";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("item", new AddItemRequest());
        return "items/add";
    }

    @PostMapping("/add")
    public String addItem(@Valid @ModelAttribute("item")AddItemRequest request, BindingResult result) {
        if (result.hasErrors()) {
            return "items/add";
        }
        shoppingListServices.addItem(request);
        return "redirect:/items/pending";
    }

    @PostMapping("/{id}/buy")
    public String markAsBought(@PathVariable("id") Long id, Model model) {
        shoppingListServices.markItemAsBought(id);
        return "redirect:/items/pending";

    }




}
