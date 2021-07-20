package min.study.atddproduct;

import io.restassured.RestAssured;
import min.study.atddproduct.presentation.CreateProductRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

class ProductControllerAcceptanceTest extends AcceptanceTestEnvironment {

    private static final String BASE_URL = "/product";

    @DisplayName("상품 생성 성공")
    @Test
    void createProductTest() {
        var request = new CreateProductRequest("iPhone 12 Pro 256GB 그래파이트", 1_300_000L, 10L);

        var response = RestAssured.given().log().all()
                                  .body(request).contentType(MediaType.APPLICATION_JSON_VALUE)
                                  .when().post(BASE_URL)
                                  .then().log().all().statusCode(HttpStatus.CREATED.value())
                                  .extract();

        assertThat(response.header("Location")).isNotBlank();
    }

    @DisplayName("상품 생성 실패 - 상품명 미기입")
    @Test
    void createProductFail01() {
        var request = new CreateProductRequest("", 1_300_000L, 10L);
        postProductRequestFail(request);
    }

    @DisplayName("상품 생성 실패 - 가격이 음수")
    @Test
    void createProductFail02() {
        var request = new CreateProductRequest("iPhone 12 Pro 256GB 그래파이트", -10L, 10L);
        postProductRequestFail(request);
    }

    @DisplayName("상품 생성 실패 - 재고가 음수")
    @Test
    void createProductFail03() {
        var request = new CreateProductRequest("iPhone 12 Pro 256GB 그래파이트", 1_300_000L, -10L);
        postProductRequestFail(request);
    }

    private void postProductRequestFail(CreateProductRequest request) {
        RestAssured.given().log().all()
                   .body(request).contentType(MediaType.APPLICATION_JSON_VALUE)
                   .when().post(BASE_URL)
                   .then().log().all().statusCode(HttpStatus.BAD_REQUEST.value());
    }
}
