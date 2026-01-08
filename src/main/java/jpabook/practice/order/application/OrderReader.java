package jpabook.practice.order.application;

import jpabook.practice.order.domain.Order;
import jpabook.practice.order.dto.OrderQuery;

import java.util.List;

public interface OrderReader {
    List<Order> findByQuery(OrderQuery query);
}
