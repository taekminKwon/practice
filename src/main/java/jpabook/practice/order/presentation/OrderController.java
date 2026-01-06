package jpabook.practice.order.presentation;

import jpabook.practice.order.application.OrderFacade;
import jpabook.practice.order.dto.OrderCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderFacade orderFacade;

    // TODO OrderDto.Response로 할 지, OrderQuery, OrderCommand 분리 후 OrderSummary 등으로 응답할 지 논의
    @PostMapping
    public OrderCreateDto.Response createOrder(@RequestBody OrderCreateDto.Request request) {
        return orderFacade.saveOrder(request);
    }
}
