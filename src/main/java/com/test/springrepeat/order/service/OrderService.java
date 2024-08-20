package com.test.springrepeat.order.service;

import com.test.springrepeat.order.entity.Order;
import com.test.springrepeat.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Transactional
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }
}
