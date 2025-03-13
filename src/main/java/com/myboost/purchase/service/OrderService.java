package com.myboost.purchase.service;

import com.myboost.purchase.entity.PurchaseOrderHeader;
import com.myboost.purchase.entity.dto.CreatePurchaseOrderDto;

import java.util.List;

public interface OrderService {
    List<PurchaseOrderHeader> findAllActiveOrders();

    PurchaseOrderHeader findOrderById(Long id);

    PurchaseOrderHeader saveOrder(CreatePurchaseOrderDto payload);
}