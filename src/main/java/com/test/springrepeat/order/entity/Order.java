package com.test.springrepeat.order.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "repeat/order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order-id")
    private Integer orderId;

    @Column(name = "order-name")
    private String orderName;

    @Column(name = "order-price")
    private Integer orderPrice;

    @Column(name = "order-quantity")
    private Integer orderQuantity;

    @Column(name = "order-create-at")
    private String orderCreateAt;

    @Column(name = "order-update-at")
    private String orderUpdateAt;

    @Column(name = "order-delete-at")
    private String orderDeleteAt;

    public Order() {
    }

    private Order(Integer orderId, String orderName, Integer orderPrice, Integer orderQuantity, String orderCreateAt, String orderUpdateAt, String orderDeleteAt) {

        this.orderId = orderId;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderQuantity = orderQuantity;
        this.orderCreateAt = orderCreateAt;
        this.orderUpdateAt = orderUpdateAt;
        this.orderDeleteAt = orderDeleteAt;
    }
    public static  Order builder(){
        return new Order();
    }

    public Order orderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Order orderName(String orderName) {
        this.orderName = orderName;
        return this;
    }

    public Order orderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
        return this;
    }

    public Order orderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
        return this;
    }

    public Order orderCreateAt(String orderCreateAt) {
        this.orderCreateAt = orderCreateAt;
        return this;
    }

    public Order orderUpdateAt(String orderUpdateAt) {
        this.orderUpdateAt = orderUpdateAt;
        return this;
    }

    public Order orderDeleteAt(String orderDeleteAt) {
        this.orderDeleteAt = orderDeleteAt;
        return this;
    }
    public Order build(){
        return new Order(orderId,orderName,orderPrice,orderQuantity,orderCreateAt,orderUpdateAt,orderDeleteAt);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderQuantity=" + orderQuantity +
                ", orderCreateAt='" + orderCreateAt + '\'' +
                ", orderUpdateAt='" + orderUpdateAt + '\'' +
                ", orderDeleteAt='" + orderDeleteAt + '\'' +
                '}';
    }
 }