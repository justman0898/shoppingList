package com.shoppinglist.data.repositories;

import com.shoppinglist.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShoppingListRepository extends JpaRepository<Item, Long> {
}
