package com.myboost.purchase.presenter;

import com.myboost.purchase.entity.PurchaseOrderHeader;
import com.myboost.purchase.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class OrderPresenter {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping("/orders")
    public Map<String, Object> findAllActiveOrders() {
        Map<String, Object> response = new HashMap<>();
        List<PurchaseOrderHeader> orders = orderServiceImpl.findAllActiveOrders();
        response.put("status", "success");
        response.put("data", orders);

        return response;
    }

    @GetMapping("/orders/{id}")
    public Map<String, Object> findOrderById(Long id) {
        Map<String, Object> response = new HashMap<>();
        PurchaseOrderHeader order = orderServiceImpl.findOrderById(id);
        response.put("status", "success");
        response.put("data", order);

        return response;
    }
}
