package jpabook.practice.order.presentation.dto;

import jpabook.practice.order.application.query.OrderSummary;
import lombok.Builder;

@Builder
public record OrderGetDto (Long orderId, Long productId, Long memberId, Integer quantity, Integer price, Integer sales) {
    public static OrderGetDto of(OrderSummary summary) {
        return OrderGetDto.builder()
                .orderId(summary.orderId())
                .productId(summary.productId())
                .memberId(summary.memberId())
                .quantity(summary.quantity())
                .price(summary.price())
                .sales(summary.sales())
                .build();
    }
}
