package jpabook.practice.order.application;

import jpabook.practice.order.application.command.OrderCommand;
import jpabook.practice.order.application.command.OrderMapper;
import jpabook.practice.order.application.query.OrderQuery;
import jpabook.practice.order.application.query.OrderQueryMapper;
import jpabook.practice.order.application.query.OrderSummary;
import jpabook.practice.order.domain.Order;
import jpabook.practice.order.domain.Product;
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
    public OrderSummary saveOrder(OrderCommand command, Product product) {
        Order order = orderMapper.createOrder(command, product);
        return orderMapper.toDto(orderStore.save(order));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderSummary> getOrdersByQuery(OrderQuery query) {
        return orderReader.findByQuery(query).stream()
                .map(OrderQueryMapper::toSummary)
                .toList();
    }
}
