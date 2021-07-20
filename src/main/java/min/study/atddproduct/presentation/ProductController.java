package min.study.atddproduct.presentation;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import min.study.atddproduct.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<URI> createProduct(@RequestBody CreateProductRequest request) {
        Long id = productService.createProduct(request.getName(),
                                               request.getPrice(),
                                               request.getInventory());
        return ResponseEntity.created(URI.create("/product/" + id)).build();
    }
}
