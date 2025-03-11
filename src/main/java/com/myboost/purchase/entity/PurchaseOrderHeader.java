package com.myboost.purchase.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "purchase_order_headers")
@Data
@NoArgsConstructor
public class PurchaseOrderHeader extends Auditing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "description")
    private String description;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "total_cost")
    private Double totalCost;

    @OneToMany(mappedBy = "purchaseOrderHeader")
    private List<PurchaseOrderDetail> purchaseOrderDetails;
}
