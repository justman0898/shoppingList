package com.shoppinglist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {
    public static final String ITEM_NOT_FOUND = "Item not found";

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException() {
        super(ITEM_NOT_FOUND);
    }
}
