# ATDD 예제

판매자가 상품을 등록하는 API를 ATDD로 구현한 예제

## 용어 사전

| 한글 | 영어 | 의미 |
|: --- :|: --- :|: --- :|
| 상품 | Product | 팔 수 있는 형태의 재화이며 상품엔 가격과 재고 정보가 포함 |
| 가격 | Charge | 상품을 판매하는 가격에 대한 정보 |
| 재고 | Inventory | 남아있는 상품 수량에 대한 정보 |

## API 정의

| Method | URI | Request | Response | Description |
|:---:|:---:|:---:|:---:|---|
| POST | `/product` | 상품명, 가격, 재고 | 상품 번호 | 상품 생성 | 
| GET | `/product/{상품번호}`  |         | 상품 정보 | 상품 조회 |

### 요구사항

1. 상품 등록 시 상품명과 가격, 재고는 유효한 값만을 사용해야 한다.
    - 상품명은 공백이나 null 등을 사용할 수 없다.
    - 가격과 재고는 0 이상의 양수만 사용한다. 
2. 상품 조회 시 받아오는 정보는 상품명, 가격, 재고, 상품 생성일이 포함된다.
