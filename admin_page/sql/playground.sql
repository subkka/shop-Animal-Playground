-- 테이블 삭제
DROP TABLE IF EXISTS refund_product;
DROP TABLE IF EXISTS refund;
DROP TABLE IF EXISTS order_product;
DROP TABLE IF EXISTS order_cancel;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS admin_account;


-- 테이블 생성
CREATE TABLE IF NOT EXISTS user (
    user_id BIGINT auto_increment NOT NULL,
    user_name VARCHAR(30) NULL,
    user_email VARCHAR(30) NULL,
    user_email_able BOOLEAN NULL,
    address VARCHAR(30) NULL,
    join_date DATE NULL,
    last_connect DATE NULL,
    user_pet VARCHAR(20) NULL,
    `dormant_user`	BOOLEAN	NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS orders (
    order_id BIGINT auto_increment NOT NULL,
    user_id BIGINT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    order_status VARCHAR(20) NOT NULL,
    total_price INTEGER NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE IF NOT EXISTS product (
    product_id BIGINT auto_increment NOT NULL,
    product_name VARCHAR(30) NULL,
    category VARCHAR(10) NULL,
    product_image BLOB NULL,
    product_desc VARCHAR(30) NULL,
    price INT NULL,
    amount INT NULL,
    is_display BOOLEAN NULL,
    product_status VARCHAR(10) NULL,
    created_at DATE NULL,
    PRIMARY KEY (product_id)
);

CREATE TABLE IF NOT EXISTS order_product (
    order_product_id INTEGER auto_increment NOT NULL,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    PRIMARY KEY (order_product_id),
    FOREIGN KEY (order_id) REFERENCES orders (order_id),
    FOREIGN KEY (product_id) REFERENCES product (product_id)
);

CREATE TABLE IF NOT EXISTS admin_account (
    admin_account_no BIGINT auto_increment NOT NULL,
    admin_id VARCHAR(16) NULL,
    password VARCHAR(16) NULL,
    permission VARCHAR(10) NULL,
    PRIMARY KEY (admin_account_no)
);

CREATE TABLE IF NOT EXISTS refund (
     refund_id BIGINT auto_increment NOT NULL,
     order_id BIGINT NOT NULL,
     application_date DATE NULL,
     process_status VARCHAR(10) NULL,
     refund_reason_type VARCHAR(20) NULL,
     refund_reason_detail VARCHAR(300) NULL,
     refund_yn VARCHAR(10) NULL,
     prod_return_yn VARCHAR(10) NOT NULL,
     PRIMARY KEY (refund_id),
     FOREIGN KEY (order_id) REFERENCES orders (order_id)
);

CREATE TABLE IF NOT EXISTS refund_product (
     refund_product_id INTEGER auto_increment NOT NULL,
     order_product_id INTEGER NOT NULL,
     refund_id BIGINT NOT NULL,
     PRIMARY KEY (refund_product_id),
     FOREIGN KEY (order_product_id) REFERENCES order_product (order_product_id),
     FOREIGN KEY (refund_id) REFERENCES refund (refund_id)
);

CREATE TABLE IF NOT EXISTS order_cancel (
    cancel_id INTEGER auto_increment NOT NULL,
    cancel_reason VARCHAR(30) NULL,
    order_id BIGINT NOT NULL,
    process_status VARCHAR(20) NULL,
    cancel_date TIMESTAMP NOT NULL,
    PRIMARY KEY (cancel_id),
    FOREIGN KEY (order_id) REFERENCES orders (order_id)
);

# user 정보 추가
select * from user;
INSERT INTO user (user_id, user_name, user_email, user_email_able, address, join_date, last_connect, user_pet,dormant_user) VALUES
       (1, '홍길동', 'john.doe@example.com', TRUE, '서울특별시 광진구', '2022-01-01', '2023-06-20', 'Dog',false),
       (2, '신사임당', 'jane.smith@example.com', TRUE, '서울특별시 종로구', '2022-02-15', '2023-06-18', 'Dog',false),
       (3, '이순신', 'alice.johnson@example.com', FALSE, '서울특별시 노원구', '2022-03-20', '2023-06-19', 'Dog',false),
       (4, '김연찬', 'robert.brown@example.com', TRUE, '서울특별시 강남구', '2022-04-10', '2023-06-21', 'Dog',false),
       (5, '오형동', 'michael.davis@example.com', FALSE, '경기도 성남', '2022-05-25', '2023-06-17', 'Cat',false),
       (6, '신윤정', 'emily.white@example.com', TRUE, '서울특별시 도봉구', '2022-06-30', '2023-06-22', 'Cat',false),
       (7, '박수빈', 'david.harris@example.com', FALSE, '서울특별시 강남구', '2022-07-15', '2023-06-15', 'Cat',false),
       (8, '박민혁', 'sophia.wilson@example.com', TRUE, '경기도 용인 ', '2022-08-25', '2023-06-16', 'Cat',false);
INSERT INTO user (user_id, user_name, user_email, user_email_able, address, join_date, last_connect, user_pet,dormant_user) VALUES
(9, '박명수', 'qkraudtn.wilson@example.com', TRUE, '경기도 분당 ', '2023-08-25', '2023-09-16', 'Cat',false),
(10, '정준하', 'wjdwnsgk.wilson@example.com', TRUE, '서울특별시 도봉구 ', '2022-02-05', '2023-02-16', 'Dog',false),
(11, '유재석', 'dbwotjr.wilson@example.com', TRUE, '강원도 철원 ', '2023-08-25', '2023-09-16', 'Cat',false),
(12, '하하', 'gkgk.wilson@example.com', TRUE, '서울특별시 마포구 ', '2023-08-25', '2023-09-16', 'Cat',false),
(13, '고윤정', 'rhdbswjd.wilson@example.com', TRUE, '서울특별시 성북구 ', '2022-01-25', '2022-02-16', 'Dog',false);

# 주문 정보 추가
select * from orders;
INSERT INTO orders (order_id, user_id, order_date, order_status, total_price) VALUES
      (1, 1, '2023-06-01 10:00:00', '입금전', 360000),
      (2, 1, '2023-06-02 11:00:00', '입금후', 30000),
      (3, 2, '2023-06-03 12:00:00', '배송중', 75000),
      (4, 3, '2023-06-04 13:00:00', '배송완료', 70000),
      (5, 3, '2023-06-05 14:00:00', '배송완료', 130000),
      (6, 4, '2023-06-06 15:00:00', '배송완료', 15000),
      (7, 5, '2023-06-07 16:00:00', '입금후', 60000),
      (8, 6, '2023-06-08 17:00:00', '배송완료', 30000),
      (9, 6, '2023-06-09 18:00:00', '배송완료', 75000),
      (10, 7, '2023-06-10 19:00:00', '입금전', 62000),
      (11, 7, '2023-06-11 10:00:00', '배송완료', 40000),
      (12, 8, '2023-06-12 11:00:00', '입금후', 120000),
      (13, 8, '2023-06-13 12:00:00', '배송중', 60000);
INSERT INTO orders (order_id, user_id, order_date, order_status, total_price) VALUES
         (14,9,'2023-06-13 13:00:00','입금전',30000),
         (15,10,'2023-06-14 14:00:00','입금전',30000),
         (16,11,'2023-06-15 15:00:00','입금전',30000),
         (17,12,'2023-06-16 16:00:00','입금전',30000),
         (18,13,'2023-06-17 17:00:00','입금전',30000);

INSERT INTO orders (order_id, user_id, order_date, order_status, total_price)
VALUES
    (19,9,'2022-06-13 13:00:00','COMPLETE',30000),
    (20,9,'2022-06-13 13:00:00','COMPLETE',40000),
    (21,9,'2022-06-13 13:00:00','COMPLETE',20000),
    (22,10,'2023-06-13 13:00:00','COMPLETE',50000),
    (23,11,'2023-06-13 13:00:00','COMPLETE',10000),
    (24,12,'2023-06-13 13:00:00','COMPLETE',30000),
    (25,13,'2023-06-13 13:00:00','COMPLETE',40000),
    (26,13,'2024-06-13 13:00:00','COMPLETE',20000),
    (27,8
,'2024-06-13 13:00:00','COMPLETE',60000),
    (28,8,'2024-06-13 13:00:00','COMPLETE',32000);

select *
from orders where order_status = 'COMPLETE';

# 상품 정보 추가
select * from product;
INSERT INTO product (product_id, product_name, category, product_image, product_desc, price, amount, is_display, product_status, created_at)
VALUES
    (1, '강아지 사료', '사료', NULL, '프리미엄 건식 사료', 50000, 100, TRUE, '판매중', '2024-06-01'),
    (2, '강아지 침대', '가구', NULL, '편안한 쿠션 침대', 70000, 50, TRUE, '판매중', '2024-06-03'),
    (3, '강아지 목줄', '액세서리', NULL, '조절 가능한 가죽 목줄', 30000, 150, TRUE, '판매중', '2024-06-04'),
    (4, '강아지 샴푸', '미용용품', NULL, '저자극성 천연 샴푸', 25000, 80, TRUE, '판매중', '2024-06-06'),
    (5, '강아지 간식', '사료', NULL, '덴탈케어 껌', 20000, 120, TRUE, '판매중', '2024-06-08'),
    (6, '강아지 장난감', '장난감', NULL, '소리나는 공', 18000, 50, TRUE, '판매중', '2024-06-11'),
    (7, '강아지 영양제', '사료', NULL, '관절 건강 케어', 35000, 100, TRUE, '판매중', '2024-06-13'),
    (8, '강아지 간식바', '사료', NULL, '닭가슴살 간식바', 25000, 150, TRUE, '판매중', '2024-06-15'),
    (9, '강아지 물병', '액세서리', NULL, '외출 시 편리한 물병', 18000, 100, TRUE, '판매중', '2024-06-17'),
    (10, '고양이 장난감', '장난감', NULL, '깃털 낚시대', 15000, 200, TRUE, '판매중', '2024-06-02'),
    (11, '고양이 화장실', '위생용품', NULL, '대형 자동 화장실', 120000, 30, TRUE, '판매중', '2024-06-05'),
    (12, '고양이 사료', '사료', NULL, '연어 기반 건식 사료', 60000, 40, TRUE, '판매중', '2024-06-07'),
    (13, '고양이 긁는 패드', '가구', NULL, '대형 긁는 패드', 30000, 80, TRUE, '판매중', '2024-06-12'),
    (14, '고양이 캣타워', '가구', NULL, '다채로운 캣타워', 75000, 30, TRUE, '판매중', '2024-06-14'),
    (15, '고양이 산책 가방', '액세서리', NULL, '편안한 산책을 위한 가방', 40000, 60, TRUE, '판매중', '2024-06-16'),
    (16, '고양이 활동 장난감', '장난감', NULL, '활동적인 고양이를 위한 장난감', 22000, 80, TRUE, '판매중', '2024-06-18');

select * from product;
# 주문상품 정보 추가
select * from order_product;
INSERT into order_product (order_product_id, order_id,product_id,quantity)
values
    # 강아지
    (1,1,1,3), # 50000 * 3 15 + 21
    (2,1,2,3), # 70000 * 3
    (3,2,3,1), # 30000
    (4,3,4,1), # 25000
    (5,3,1,1), # 50000
    (6,4,2,1),  # 70000
    # 고양이
    (7,5,10,1), # 10000 * 3
    (8,5,11,1), # 120000 * 3
    (9,6,10,1), # 15000 * 3
    (10,7,12,3), # 60000 * 3
    (11,8,13,1), # 30000 * 1
    (12,9,14,1), # 750000
    (13,10,15,1), # 40000
    (14,10,16,1), # 22000
    (15,11,10,1), # 40000
    (16,12,11,1), # 120000
    (17,13,12,1); # 60000

INSERT into order_product (order_product_id, order_id,product_id,quantity)
values
    (18,14,12,1), #60000
    (19,15,7,1), # 35000
    (20,16,13,1), # 30000
    (21,17,14,1), # 75000
    (22,18,12,1); # 60000

INSERT into order_product (order_product_id, order_id,product_id,quantity)
values
    (23,19,10,1),#15000
    (24,20,11,1),# 120000
    (25,21,12,1),#60000
    (26,22,9,1), #18000
    (27,23,13,1),#30000
    (28,24,14,1),#75000
    (29,25,15,1),#40000
    (30,26,16,1),#22000
    (31,27,10,1),#15000
    (32,28,11,1);#120000

update orders
set total_price = 15000
where order_id =27;

INSERT INTO orders (order_id, user_id, order_date, order_status, total_price) VALUES
      (null,9,'2023-06-13 13:00:00','입금전',60000),
      (null,10,'2023-06-14 14:00:00','입금전',35000),
      (null,11,'2023-06-15 15:00:00','입금전',30000),
      (null,12,'2023-06-16 16:00:00','입금전',75000),
      (null,13,'2023-06-17 17:00:00','입금전',60000);

select *
from refund;

INSERT INTO
    refund(refund_id, order_id, application_date, process_status, refund_reason_type, refund_reason_detail, refund_yn, prod_return_yn)
VALUES
    (null, 1, '2024-01-01', '처리완료', '단순변심', '변경하고싶어요.', '반려', 'n'),
    (null, 2, '2024-01-02', '처리중', '상품불량', '상품에 문제가 있네요.', '확정', 'n'),
    (null, 3, '2024-01-03', '처리대기', '상품불량', '상품에 이물질이 묻었어요.', null, 'n'),
    (null, 4, '2024-01-01', '처리완료', '단순변심', '변경하고싶어요.', '반려', 'n'),
    (null, 5, '2024-01-02', '처리중', '상품불량', '상품에 문제가 있네요.', '확정', 'n'),
    (null, 6, '2024-01-03', '처리대기', '상품불량', '상품에 이물질이 묻었어요.', null, 'n'),
    (null, 7, '2024-01-03', '처리대기', '상품불량', '글자수테스트중입니다글자수테스트중입니다글자수테스트중입니다글자수테스트중입니다글자수테스트중입니다글자수테스트중입니다글자수테스트중입니다글자수테스트중입니다글자수테스트중입니다글자수테스트중입니다', null, 'n');

insert into
    refund_product
values
    (null, 6, 4),
    (null, 10, 7),
    (null, 13, 10),
    (null, 14, 10),
    (null, 17, 13),
    (null, 20, 16);

update refund
set
    prod_return_yn = 'N'
where
    process_status != '처리완료';

update refund
set
    prod_return_yn = 'Y'
where
    process_status = '처리완료';


