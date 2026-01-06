package jpabook.practice.order.infrastructure;

import jpabook.practice.order.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
