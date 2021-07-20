package min.study.atddproduct;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long createProduct(String name, Long price, Long inventory) {
        return productRepository.save(new Product(name, price, inventory)).getId();
    }
}
