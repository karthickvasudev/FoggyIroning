package com.example.FoggyIroning.api.v1.orders.modals;

import com.example.FoggyIroning.api.v1.orderlines.OrderLines;
import com.example.FoggyIroning.api.v1.orders.constants.ORDERSTATUS;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderModal {
    private String id;
    private String customerId;
    private LocalDateTime orderDate;
    private LocalDateTime startedDate;
    private LocalDateTime completedDate;
    private LocalDateTime expectedDeliveryDate;
    private LocalDateTime deliveredDate;
    private Integer count;
    private Double amount;
    private ORDERSTATUS status;
    private LocalDateTime createOn;
    private String createUserName;
    private String createUserEmail;
    private LocalDateTime lastUpdatedOn;
    private String lastUpdatedUserName;
    private String lastUpdatedEmail;
    private List<OrderLines> orderLines;
    @Getter
    @Setter
    public static class OrderLines{
        private String id;
        private String productId;
        private String productName;
        private Integer count;
        private Double price;
        private LocalDateTime createdOn;
        private LocalDateTime lastUpdatedOn;
    }
}
