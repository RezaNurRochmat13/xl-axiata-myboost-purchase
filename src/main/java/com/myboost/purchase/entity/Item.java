package com.myboost.purchase.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item extends Auditing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "cost")
    private Double cost;

    @OneToMany(mappedBy = "item")
    private List<PurchaseOrderDetail> purchaseOrderDetails;
}
