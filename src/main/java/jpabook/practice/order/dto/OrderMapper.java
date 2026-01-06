package jpabook.practice.order.dto;

import jpabook.practice.order.domain.Order;
import jpabook.practice.order.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order createOrder(OrderCreateDto.Request request, Product product) {
        return Order.createOrder(
                request.memberId(),
                product,
                product.getProductName(),
                product.getPrice(),
                request.quantity()
        );
    }

    public OrderCreateDto.Response toDto(Order order) {
        return new OrderCreateDto.Response(
                order.getProduct().getId(),
                order.getMemberId(),
                order.getQuantity(),
                order.getProduct().getPrice(),
                order.getSales()
        );
    }
}
