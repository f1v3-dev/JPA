package com.f1v3.jpa.transaction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {class name}.
 *
 * @author 정승조
 * @version 2024. 08. 25.
 */
@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;


    @Test
    void test1() {
        itemService.save();
        itemService.saveWithTransaction();

        itemService.saveWithException();
        itemService.saveWithTransactionException();
    }


    @Test
    void test2() {
        itemService.sample();
    }
}