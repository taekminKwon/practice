package jpabook.practice;

import jpabook.practice.order.application.OrderService;
import jpabook.practice.order.application.query.OrderSummary;
import jpabook.practice.order.domain.Code;
import jpabook.practice.order.domain.Product;
import jpabook.practice.order.presentation.dto.OrderPostDto;
import jpabook.practice.order.infrastructure.ProductRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PracticeApplicationTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Tag(value = "저장 로직 확인")
    void controllerTest() {
        // given
        Integer quantity = 10000;
        Long memberId = 1L;
        Long productId = 1L;

        OrderPostDto.Request request = new OrderPostDto.Request(productId, memberId, quantity);
        Product product = Product.createProduct("제품1", 10000, new Code("코드1", "회사 코드1"));
        productRepository.save(product);

        OrderPostDto.Response response = new OrderPostDto.Response(1L, 1L, 1L, 10000, 10000, 10000 * 10000);

        // when
        OrderSummary orderSummary = orderService.saveOrder(request.toCommand(), product);
        System.out.println(orderSummary.toString());
        OrderPostDto.Response result = OrderPostDto.Response.of(orderSummary);

        // then
        assertEquals(response, result);
    }

}
