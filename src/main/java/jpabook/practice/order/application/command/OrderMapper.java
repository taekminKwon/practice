package jpabook.practice.order.application.command;

import jpabook.practice.order.application.query.OrderSummary;
import jpabook.practice.order.domain.Order;
import jpabook.practice.order.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order createOrder(OrderCommand command, Product product) {
        return Order.createOrder(
                command.memberId(),
                product,
                command.quantity()
        );
    }

    public OrderSummary toDto(Order order) {
        return new OrderSummary(
                order.getId(),
                order.getProduct().getId(),
                order.getMemberId(),
                order.getQuantity(),
                order.getOrderPrice(),
                order.getSales()
        );
    }
}
