package jpabook.practice.order.infrastructure;

import jpabook.practice.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderJpaRepository extends JpaRepository<Order, Long> {
    // 스냅 샷 컬럼(product name, product price 등등) 이 없을 때는
    @Query("select o " +
            "from Order as o " +
            "join o.product p " +
            "where p.productName like %:productName%")
    List<Order> findByProductName(String productName);
}
