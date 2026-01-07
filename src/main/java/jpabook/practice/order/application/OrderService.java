package jpabook.practice.order.application;

import jpabook.practice.order.domain.Product;
import jpabook.practice.order.dto.OrderCreateDto;
import jpabook.practice.order.dto.OrderQuery;
import jpabook.practice.order.dto.OrderSummary;

import java.util.List;

public interface OrderService {
    OrderCreateDto.Response saveOrder(OrderCreateDto.Request request, Product product);

    List<OrderSummary> getOrdersByQuery(OrderQuery request);
}
