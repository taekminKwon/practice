package jpabook.practice.order.infrastructure;

import jpabook.practice.order.domain.Order;
import jpabook.practice.order.dto.OrderQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class OrderJpaReaderImpl implements OrderReader {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> findByQuery(OrderQuery query) {
        // if (!query.productName().isEmpty()) 이런 조건 식이 변경될 때마다 쿼리의 모양새가 달라져서
        // jpa 내부에서 호출해야하는 함수가 달라짐
        // ex : findByProductName, findByMemberId .... 등등
        return orderRepository.findByProductName(query.productName());
    }
}
