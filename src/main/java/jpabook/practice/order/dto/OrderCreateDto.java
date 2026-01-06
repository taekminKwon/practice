package jpabook.practice.order.dto;

public class OrderCreateDto {
    public record Request(Long productId, Long memberId, Integer quantity) {

    }

    public record Response(Long productId, Long memberId, Integer quantity, Integer price, Integer sales) {
    }
}
