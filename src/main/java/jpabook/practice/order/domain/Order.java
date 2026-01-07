package jpabook.practice.order.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private String productName;

    private Integer orderPrice;

    private Integer quantity;

    private Integer sales;

    public static Order createOrder(
        Long memberId,
        Product product,
        int quantity
    ) {
        Order order = new Order();
        order.product = product;
        order.productName = product.getProductName();;
        order.memberId = memberId;
        order.orderPrice = product.getPrice();
        order.quantity = quantity;

        // 비즈니스 로직을 도메인에서 관리
        order.sales = product.getPrice() * quantity;
        return order;
    }
}
