package jpabook.practice.order.application;

import jpabook.practice.order.domain.Order;
import jpabook.practice.order.domain.Product;
import jpabook.practice.order.dto.OrderCreateDto;
import jpabook.practice.order.dto.OrderMapper;
import jpabook.practice.order.infrastructure.OrderStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderStore orderStore;
    private final OrderMapper orderMapper;

    @Transactional
    @Override
    public OrderCreateDto.Response saveOrder(OrderCreateDto.Request request, Product product) {
        Order order = orderMapper.createOrder(request, product);
        return orderMapper.toDto(orderStore.save(order));
    }
}
