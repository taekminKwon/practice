package jpabook.practice.order.presentation.dto;

import jpabook.practice.order.application.command.OrderCommand;
import jpabook.practice.order.application.query.OrderSummary;
import lombok.Builder;

public class OrderPostDto {
    public record Request(Long productId, Long memberId, Integer quantity) {
        public OrderCommand toCommand() {
            return new OrderCommand(productId, memberId, quantity);
        }
    }

    @Builder
    public record Response(Long orderId, Long productId, Long memberId, Integer quantity, Integer price, Integer sales) {
        public static Response of(OrderSummary orderSummary) {
            return Response.builder()
                    .orderId(orderSummary.orderId())
                    .productId(orderSummary.productId())
                    .memberId(orderSummary.memberId())
                    .quantity(orderSummary.quantity())
                    .price(orderSummary.price())
                    .sales(orderSummary.sales())
                    .build();
        }
    }
}
