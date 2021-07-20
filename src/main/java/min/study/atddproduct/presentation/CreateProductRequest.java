package min.study.atddproduct.presentation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CreateProductRequest {

    @NotBlank
    private String name;

    @PositiveOrZero
    private Long price;

    @PositiveOrZero
    private Long inventory;
}
