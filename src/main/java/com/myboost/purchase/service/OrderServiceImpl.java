package com.myboost.purchase.service;

import com.myboost.purchase.entity.Item;
import com.myboost.purchase.entity.PurchaseOrderDetail;
import com.myboost.purchase.entity.PurchaseOrderHeader;
import com.myboost.purchase.entity.dto.CreatePurchaseOrderDto;
import com.myboost.purchase.exception.ResourceNotFound;
import com.myboost.purchase.repository.ItemRepository;
import com.myboost.purchase.repository.PurchaseOrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private PurchaseOrderHeaderRepository purchaseOrderHeaderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<PurchaseOrderHeader> findAllActiveOrders() {
        return purchaseOrderHeaderRepository.findActivePurchaseOrderHeaders();
    }

    @Override
    public PurchaseOrderHeader findOrderById(Long id) {
        return purchaseOrderHeaderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Order not found with id: " + id));
    }

    @Override
    public PurchaseOrderHeader saveOrder(CreatePurchaseOrderDto payload) {
        Item item = itemRepository.findById(payload.getItemId())
                .orElseThrow(() -> new ResourceNotFound("Item not found with id: " + payload.getItemId()));

        PurchaseOrderHeader purchaseOrderHeader = new PurchaseOrderHeader();
        purchaseOrderHeader.setDescription(payload.getDescription());
        purchaseOrderHeader.setOrderDate(LocalDateTime.now());

        PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
        purchaseOrderDetail.setItemCost(payload.getItemCost());
        purchaseOrderDetail.setItem(item);
        purchaseOrderDetail.setItemPrice(payload.getItemPrice());
        purchaseOrderDetail.setItemQuantity(payload.getItemQuantity());
        purchaseOrderHeader.getPurchaseOrderDetails().add(purchaseOrderDetail);

        return purchaseOrderHeaderRepository.save(purchaseOrderHeader);
    }

}
