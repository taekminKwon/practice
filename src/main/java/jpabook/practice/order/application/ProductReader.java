package jpabook.practice.order.application;

import jpabook.practice.order.domain.Product;

public interface ProductReader {
    Product read(Long productId);
}
