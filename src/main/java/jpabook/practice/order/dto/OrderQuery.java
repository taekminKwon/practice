package jpabook.practice.order.dto;

public record OrderQuery(Long productId, String productName, Integer memberId) {

}
