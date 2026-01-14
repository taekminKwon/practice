package jpabook.practice.order.presentation;

import jpabook.practice.order.application.OrderFacade;
import jpabook.practice.order.application.OrderService;
import jpabook.practice.order.presentation.dto.OrderPostDto;
import jpabook.practice.order.application.query.OrderQuery;
import jpabook.practice.order.application.query.OrderSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderFacade orderFacade;
    private final OrderService orderService;

    @PostMapping
    public OrderPostDto.Response createOrder(@RequestBody OrderPostDto.Request request) {
        return OrderPostDto.Response.of(orderFacade.saveOrder(request.toCommand()));
    }


    @GetMapping
    public List<OrderSummary> getOrderByProductName(@RequestBody OrderQuery request) {
        return orderService.getOrdersByQuery(request);
    }
}
