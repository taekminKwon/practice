package jpabook.practice.order.application;

import jpabook.practice.order.application.command.OrderCommand;
import jpabook.practice.order.application.query.OrderSummary;
import jpabook.practice.order.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;
    private final ProductService productService;

    @Transactional
    public OrderSummary saveOrder(OrderCommand command) {
        Product product = productService.readProduct(command.productId());
        return orderService.saveOrder(command, product);
    }
}
