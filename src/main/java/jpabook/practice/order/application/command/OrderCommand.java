package jpabook.practice.order.application.command;

public record OrderCommand (Long productId, Long memberId, Integer quantity){
}
