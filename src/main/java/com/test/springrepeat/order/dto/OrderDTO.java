package com.test.springrepeat.order.dto;

public class OrderDTO {
    private Integer  orderId;
    private String orderName;
    private Integer orderPrice;
    private Integer orderQuantity;
    private String orderCreateAt;
    private String orderUpdateAt;
    private String orderDeleteAt;

    public OrderDTO() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderCreateAt() {
        return orderCreateAt;
    }

    public void setOrderCreateAt(String orderCreateAt) {
        this.orderCreateAt = orderCreateAt;
    }

    public String getOrderUpdateAt() {
        return orderUpdateAt;
    }

    public void setOrderUpdateAt(String orderUpdateAt) {
        this.orderUpdateAt = orderUpdateAt;
    }

    public String getOrderDeleteAt() {
        return orderDeleteAt;
    }

    public void setOrderDeleteAt(String orderDeleteAt) {
        this.orderDeleteAt = orderDeleteAt;
    }

    public OrderDTO(Integer orderId, String orderName, Integer orderPrice, Integer orderQuantity, String orderCreateAt, String orderUpdateAt, String orderDeleteAt) {

        this.orderId = orderId;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderQuantity = orderQuantity;
        this.orderCreateAt = orderCreateAt;
        this.orderUpdateAt = orderUpdateAt;
        this.orderDeleteAt = orderDeleteAt;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
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
