package min.study.atddproduct.service;

import lombok.RequiredArgsConstructor;
import min.study.atddproduct.domain.Product;
import min.study.atddproduct.domain.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long createProduct(String name, Long price, Long inventory) {
        return productRepository.save(new Product(name, price, inventory)).getId();
    }
}
