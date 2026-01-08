package jpabook.practice.order.dto;

public record OrderQuery(String productName, Long memberId, Integer orderPrice) {

}
