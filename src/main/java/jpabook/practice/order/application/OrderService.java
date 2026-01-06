package jpabook.practice.order.application;

import jpabook.practice.order.domain.Product;
import jpabook.practice.order.dto.OrderCreateDto;

public interface OrderService {
    OrderCreateDto.Response saveOrder(OrderCreateDto.Request request, Product product);
}
