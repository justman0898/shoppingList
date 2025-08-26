package com.shoppinglist;

import org.springframework.boot.SpringApplication;

public class TestShoppinglistApplication {

    public static void main(String[] args) {
        SpringApplication.from(ShoppingListApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
