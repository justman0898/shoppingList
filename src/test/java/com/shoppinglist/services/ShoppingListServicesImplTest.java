package com.shoppinglist.services;

import com.shoppinglist.data.repositories.ShoppingListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ShoppingListServicesImplTest {

    @MockitoBean
    ShoppingListRepository shoppingListRepository;

    @Autowired
    ShoppingListServicesImpl shoppingListServices;




}