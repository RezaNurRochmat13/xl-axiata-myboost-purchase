package com.myboost.purchase.service;

import com.myboost.purchase.entity.Item;
import com.myboost.purchase.exception.ResourceNotFound;
import com.myboost.purchase.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAllActiveItems() {
        return itemRepository.findActiveItems();
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Item not found with id: " + id));
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id, Item payload) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Item not found with id: " + id));

        item.setName(payload.getName());
        item.setDescription(payload.getDescription());
        item.setPrice(payload.getPrice());
        item.setQuantity(payload.getQuantity());
        item.setCost(payload.getCost());

        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Item not found with id: " + id));
        itemRepository.delete(item);
    }
}
