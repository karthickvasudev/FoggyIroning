package com.example.FoggyIroning.api.v1.orders;

import com.example.FoggyIroning.api.v1.orders.modals.OrderModal;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/orders")
@AllArgsConstructor
public class OrdersController {
    private final OrdersService service;

    @PostMapping("create")
    public Orders createOrder(@RequestBody OrderModal modal) {
        return service.createOrder(modal);
    }

    @GetMapping("getall")
    public List<Orders> getAllOrders(@RequestParam Map<String,String> query){
        return service.getAllOrders(query);
    }

    @GetMapping("{orderId}")
    public Orders getOrder(@PathVariable String orderId){
        return service.getOrder(orderId);
    }

    @PutMapping("{orderId}")
    public void updateOrder(@RequestBody OrderModal modal){

    }

    @PutMapping("{orderId}/completed")
    public Orders completeOrder(@PathVariable String orderId){
        return service.completeOrder(orderId);
    }

    @PutMapping("{orderId}/cancel")
    public Orders cancelOrder(@PathVariable String orderId) {
        return service.cancelOrder(orderId);
    }

    @PutMapping("{orderId}/delivered")
    public Orders deliveredOrder(@PathVariable String orderId){
        return service.deliveredOrder(orderId);
    }

    @GetMapping("todayneworders")
    public List<Orders> getTodayNewOrder(){
        return service.getTodayNewOrders();
    }
}
