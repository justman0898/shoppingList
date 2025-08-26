package com.shoppinglist.data.repositories;

import com.shoppinglist.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ShoppingListRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);
}
