package com.myboost.purchase.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "purchase_order_details")
@Data
@NoArgsConstructor
public class PurchaseOrderDetail extends Auditing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_order_header_id")
    private PurchaseOrderHeader purchaseOrderHeader;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "item_quantity")
    private Integer itemQuantity;

    @Column(name = "item_cost")
    private Double itemCost;

    @Column(name = "item_price")
    private Double itemPrice;

}
