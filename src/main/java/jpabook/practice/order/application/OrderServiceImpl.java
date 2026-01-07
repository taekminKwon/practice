package jpabook.practice.order.application;

import jpabook.practice.order.domain.Order;
import jpabook.practice.order.domain.Product;
import jpabook.practice.order.dto.*;
import jpabook.practice.order.infrastructure.OrderReader;
import jpabook.practice.order.infrastructure.OrderStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderStore orderStore;
    private final OrderMapper orderMapper;
    private final OrderReader orderReader;

    @Transactional
    @Override
    public OrderCreateDto.Response saveOrder(OrderCreateDto.Request request, Product product) {
        Order order = orderMapper.createOrder(request, product);
        return orderMapper.toDto(orderStore.save(order));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderSummary> getOrdersByQuery(OrderQuery query) {
        return orderReader.findByQuery(query).stream()
                .map(OrderQueryMapper::toDto)
                .toList();
    }
}
