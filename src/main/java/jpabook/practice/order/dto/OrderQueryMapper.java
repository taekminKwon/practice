package jpabook.practice.order.dto;

import jpabook.practice.order.domain.Order;

public class OrderQueryMapper {
    public static OrderSummary toDto(Order order) {
        return new OrderSummary(order.getProductName(), order.getOrderPrice(), order.getSales());
    }
}
