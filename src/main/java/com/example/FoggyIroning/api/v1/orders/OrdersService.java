package com.example.FoggyIroning.api.v1.orders;

import com.example.FoggyIroning.api.v1.orderlines.OrderLines;
import com.example.FoggyIroning.api.v1.orders.constants.ORDERSTATUS;
import com.example.FoggyIroning.api.v1.orders.modals.OrderModal;
import com.example.FoggyIroning.securityConfiguration.googleauthenticator.TokenDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final TokenDetails tokenDetails;

    public Orders createOrder(OrderModal modal) {
        List<OrderModal.OrderLines> orderLines = modal.getOrderLines();

        List<OrderLines> orderLinesList = new ArrayList<>();
        orderLines.stream().forEach(ol -> {
            OrderLines newOrderLines = new OrderLines();
            newOrderLines.setProductId(ol.getProductId());
            newOrderLines.setCount(ol.getCount());
            newOrderLines.setPrice(ol.getPrice());
            newOrderLines.setCreatedOn(LocalDateTime.now());
            orderLinesList.add(newOrderLines);
        });

        Orders order = Orders.builder()
                .customerId(modal.getCustomerId())
                .orderDate(LocalDateTime.now())
                .expectedDeliveryDate(LocalDateTime.now().plusDays(1))
                .amount(modal.getAmount())
                .status(ORDERSTATUS.NOT_STARTED)
                .orderLines(orderLinesList)
                .createOn(LocalDateTime.now())
                .createUserEmail(tokenDetails.getEmail())
                .createUserName(tokenDetails.getName())
                .build();
        return ordersRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrder(String orderId) {
        return ordersRepository.findById(orderId).get();
    }

    public void updateOrder(OrderModal modal) {

    }

    public Orders startOrder(String orderId) {
        Orders order = ordersRepository.findById(orderId).get();
        order.setStatus(ORDERSTATUS.IN_PROGRESS);
        order.setLastUpdatedOn(LocalDateTime.now());
        order.setLastUpdatedEmail(tokenDetails.getEmail());
        order.setLastUpdatedUserName(tokenDetails.getName());
        return ordersRepository.save(order);
    }

    public Orders completeOrder(String orderId) {
        Orders order = ordersRepository.findById(orderId).get();
        order.setStatus(ORDERSTATUS.COMPLETED);
        order.setLastUpdatedOn(LocalDateTime.now());
        order.setLastUpdatedEmail(tokenDetails.getEmail());
        order.setLastUpdatedUserName(tokenDetails.getName());
        return ordersRepository.save(order);
    }

    public Orders cancelOrder(String orderId) {
        Orders order = ordersRepository.findById(orderId).get();
        order.setStatus(ORDERSTATUS.CANCELLED);
        order.setLastUpdatedOn(LocalDateTime.now());
        order.setLastUpdatedEmail(tokenDetails.getEmail());
        order.setLastUpdatedUserName(tokenDetails.getName());
        return ordersRepository.save(order);
    }
}
