package jpabook.practice.order.presentation;

import jpabook.practice.order.application.OrderFacade;
import jpabook.practice.order.application.OrderService;
import jpabook.practice.order.dto.OrderCreateDto;
import jpabook.practice.order.dto.OrderQuery;
import jpabook.practice.order.dto.OrderSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderFacade orderFacade;
    private final OrderService orderService;

    // TODO OrderDto.Response로 할 지, OrderQuery, OrderCommand 분리 후 OrderSummary 등으로 응답할 지 논의
    @PostMapping
    public OrderCreateDto.Response createOrder(@RequestBody OrderCreateDto.Request request) {
        return orderFacade.saveOrder(request);
    }


    @GetMapping
    public List<OrderSummary> getOrderByProductName(@RequestBody OrderQuery request) {
        return orderService.getOrdersByQuery(request);
    }
}
