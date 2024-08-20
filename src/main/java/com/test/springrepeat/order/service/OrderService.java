package com.test.springrepeat.order.service;

import com.test.springrepeat.order.dto.OrderDTO;
import com.test.springrepeat.order.entity.Order;
import com.test.springrepeat.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<Order> findOrderById(Integer orderId) {
        if (orderId == null || orderId <= 0) {
            throw new IllegalArgumentException("상품의 id는 없으면 안되거나 0보다 커야합니다.");
        }
        return orderRepository.findById(orderId);
    }

}
