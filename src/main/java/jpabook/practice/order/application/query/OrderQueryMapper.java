package jpabook.practice.order.application.query;

import jpabook.practice.order.domain.Order;

public class OrderQueryMapper {
    public static OrderSummary toSummary(Order order) {
        return new OrderSummary(order.getId(), order.getProduct().getId(), order.getMemberId(), order.getQuantity(), order.getOrderPrice(), order.getSales());
    }
}
