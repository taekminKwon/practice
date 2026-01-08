package jpabook.practice.order.application;

import jpabook.practice.order.domain.Order;

public interface OrderStore {
    Order save(Order order);
}
