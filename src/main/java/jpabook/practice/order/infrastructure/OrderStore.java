package jpabook.practice.order.infrastructure;

import jpabook.practice.order.domain.Order;

public interface OrderStore {
    Order save(Order order);
}
