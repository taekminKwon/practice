package jpabook.practice.order.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;
    private Integer price;

    @Embedded
    private Code code;

    public boolean isDuplicated(Product product) {
        return code.equals(product.getCode());
    }
}
