package jpabook.practice.order.application;

import jpabook.practice.order.application.command.OrderCommand;
import jpabook.practice.order.domain.Product;
import jpabook.practice.order.application.query.OrderQuery;
import jpabook.practice.order.application.query.OrderSummary;

import java.util.List;

public interface OrderService {
    OrderSummary saveOrder(OrderCommand command, Product product);

    List<OrderSummary> getOrdersByQuery(OrderQuery request);
}
