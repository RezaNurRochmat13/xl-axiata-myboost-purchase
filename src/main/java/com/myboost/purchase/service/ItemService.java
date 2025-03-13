package com.myboost.purchase.service;

import com.myboost.purchase.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllActiveItems();
    Item findItemById(Long id);
    Item saveItem(Item item);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
}
