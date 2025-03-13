package com.myboost.purchase.presenter;

import com.myboost.purchase.entity.Item;
import com.myboost.purchase.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ItemPresenter {
    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @GetMapping("/items")
    public Map<String, Object> findAllActiveItems() {
        Map<String, Object> response = new HashMap<>();
        List<Item> items = itemServiceImpl.findAllActiveItems();
        response.put("status", "success");
        response.put("data", items);

        return response;
    }

    @GetMapping("/items/{id}")
    public Map<String, Object> findItemById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Item item = itemServiceImpl.findItemById(id);
        response.put("status", "success");
        response.put("data", item);

        return response;
    }

    @PostMapping("/items")
    public Map<String, Object> saveItem(@RequestBody Item item) {
        Map<String, Object> response = new HashMap<>();
        Item savedItem = itemServiceImpl.saveItem(item);
        response.put("status", "success");
        response.put("data", savedItem);

        return response;
    }

    @PutMapping("/items/{id}")
    public Map<String, Object> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Map<String, Object> response = new HashMap<>();
        Item updatedItem = itemServiceImpl.updateItem(id, item);
        response.put("status", "success");
        response.put("data", updatedItem);

        return response;
    }

    @DeleteMapping("/items/{id}")
    public Map<String, Object> deleteItem(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        itemServiceImpl.deleteItem(id);
        response.put("status", "success");
        response.put("data", "Item deleted successfully");

        return response;
    }
}
