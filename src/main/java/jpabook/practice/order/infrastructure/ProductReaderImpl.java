package jpabook.practice.order.infrastructure;

import jpabook.practice.order.application.ProductReader;
import jpabook.practice.order.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductReaderImpl implements ProductReader {
    private final ProductRepository productRepository;

    @Override
    public Product read(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }
}
