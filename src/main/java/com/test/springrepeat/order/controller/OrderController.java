package com.test.springrepeat.order.controller;

import com.test.springrepeat.order.dto.OrderDTO;
import com.test.springrepeat.order.entity.Order;
import com.test.springrepeat.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>>getALLOrders(){
        List<Order> orders = orderService.findAllOrders();
        if (orders.isEmpty()){
            return ResponseEntity.status(404)
                    .header("message","등록된 상품이 없습니다.")
                    .build();
        }return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order>getOrderById(@PathVariable Integer OrderId){
        try {
            Optional<Order> getOrder = orderService.findOrderById(OrderId);
            if (getOrder.isPresent()) {
                return ResponseEntity.ok(getOrder.get());
            } else {
                return ResponseEntity.status(404)
                        .header("message", "조회할 상품의 데이터가 없습니다.")
                        .build();
            }
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(400)
                    .header("message",e.getMessage())
                    .build();
        }
    }
}
