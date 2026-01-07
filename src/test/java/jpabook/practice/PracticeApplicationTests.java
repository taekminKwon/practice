package jpabook.practice;

import jpabook.practice.order.application.OrderService;
import jpabook.practice.order.domain.Code;
import jpabook.practice.order.domain.Order;
import jpabook.practice.order.domain.Product;
import jpabook.practice.order.dto.OrderCreateDto;
import jpabook.practice.order.infrastructure.OrderRepository;
import jpabook.practice.order.infrastructure.OrderStore;
import jpabook.practice.order.infrastructure.ProductReader;
import jpabook.practice.order.infrastructure.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PracticeApplicationTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
        // given
        Integer quantity = 10000;
        Long memberId = 1L;
        Long productId = 1L;

        OrderCreateDto.Request request = new OrderCreateDto.Request(productId, memberId, quantity);
        Product product = Product.createProduct("제품1", 10000, new Code("코드1", "회사 코드1"));
        productRepository.save(product);

        Integer price = product.getPrice();
        Integer sales = price * quantity;

        OrderCreateDto.Response response = new OrderCreateDto.Response(productId, memberId, quantity, price, sales);

        // when
        OrderCreateDto.Response result = orderService.saveOrder(request, product);

        // then
        assertEquals(response, result);
    }

}
