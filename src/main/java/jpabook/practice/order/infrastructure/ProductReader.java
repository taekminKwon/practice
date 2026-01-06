package jpabook.practice.order.infrastructure;

import jpabook.practice.order.domain.Product;

public interface ProductReader {
    Product read(Long productId);
}
