package jpabook.practice.order.infrastructure;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.practice.order.application.OrderReader;
import jpabook.practice.order.domain.Order;
import jpabook.practice.order.dto.OrderQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static jpabook.practice.order.domain.QOrder.order;

@Component
@RequiredArgsConstructor
public class OrderQueryDslReaderImpl implements OrderReader {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Order> findByQuery(OrderQuery query) {
        return jpaQueryFactory
                .selectFrom(order)
                .join(order.product)
                .where(
                        productNameLike(query.productName()),
                        memberIdEq(query.memberId()),
                        orderPriceGoe(query.orderPrice())
                )
                .fetch();
   }

   private BooleanExpression productNameLike(String productName) {
        if (StringUtils.isNullOrEmpty(productName)) {
            return null;
        }

        return order.product.productName.contains(productName);
   }

    private BooleanExpression memberIdEq(Long memberId) {
        if (memberId == null) {
            return null;
        }

        return order.memberId.eq(memberId);
    }

    private BooleanExpression orderPriceGoe(Integer orderPrice) {
        if (orderPrice == null) {
            return null;
        }

        return order.orderPrice.goe(orderPrice);
    }
}
