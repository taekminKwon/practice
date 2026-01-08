package jpabook.practice.order.application;

import jpabook.practice.order.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductReader productReader;

    @Transactional(readOnly = true)
    public Product readProduct(Long productId) {
        return productReader.read(productId);
    }
}
