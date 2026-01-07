package jpabook.practice.order.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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

    public static Product createProduct(String productName, Integer price, Code code) {
        Product product = new Product();
        product.productName = productName;
        product.price = price;
        product.code = code;
        return product;
    }
    public boolean isDuplicated(Product product) {
        return code.equals(product.getCode());
    }
}
