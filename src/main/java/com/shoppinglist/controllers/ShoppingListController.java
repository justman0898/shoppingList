package com.shoppinglist.controllers;

import ch.qos.logback.core.model.Model;
import com.shoppinglist.services.ShoppingListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ShoppingListController {

    @Autowired
    private ShoppingListServices shoppingListServices;

    @GetMapping("/pending")
    public String getPendingItems(Model model) {

        return "items/pending";
    }



}
