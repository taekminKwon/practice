package jpabook.practice.order.application.query;

public record OrderSummary(Long orderId, Long productId, Long memberId, Integer quantity, Integer price, Integer sales) {
}
