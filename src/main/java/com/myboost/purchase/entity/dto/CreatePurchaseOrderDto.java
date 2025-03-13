package com.myboost.purchase.entity.dto;

import lombok.Data;

@Data
public class CreatePurchaseOrderDto {
    private Long itemId;
    private String description;
    private Double totalPrice;
    private Double totalCost;
    private Integer itemQuantity;
    private Double itemCost;
    private Double itemPrice;
}
