package com.myboost.purchase.repository;

import com.myboost.purchase.entity.PurchaseOrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderHeaderRepository extends JpaRepository<PurchaseOrderHeader, Long> {
    @Query(value = "SELECT p FROM PurchaseOrderHeader p WHERE p.deletedAt is null")
    List<PurchaseOrderHeader> findActivePurchaseOrderHeaders();
}
