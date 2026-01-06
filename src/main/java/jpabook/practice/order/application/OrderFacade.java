package jpabook.practice.order.application;

import jpabook.practice.order.domain.Product;
import jpabook.practice.order.dto.OrderCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;
    private final ProductService productService;

    @Transactional
    public OrderCreateDto.Response saveOrder(OrderCreateDto.Request request) {
        Product product = productService.readProduct(request.productId());
        return orderService.saveOrder(request, product);
    }
}
