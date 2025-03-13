package com.myboost.purchase.repository;

import com.myboost.purchase.entity.PurchaseOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderDetailRepository extends JpaRepository<PurchaseOrderDetail, Long> {
    @Query(value = "SELECT p FROM PurchaseOrderDetail p WHERE p.deletedAt is null")
    List<PurchaseOrderDetail> findActivePurchaseOrderDetails();
}
