package com.example.FoggyIroning.api.v1.orders;

import com.example.FoggyIroning.api.v1.orders.constants.ORDERSTATUS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, String> {
    List<Orders> findAllByOrderByOrderDateDesc();

    List<Orders> findAllByStatusAndOrderDate(ORDERSTATUS status, LocalDateTime orderDate);
}
