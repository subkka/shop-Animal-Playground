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
    user_no BIGINT NOT NULL,
    user_name VARCHAR(30) NULL,
    user_email VARCHAR(30) NULL,
    user_email_able BOOLEAN NULL,
    address VARCHAR(30) NULL,
    join_date DATE NULL,
    last_connect DATE NULL,
    user_pet VARCHAR(20) NULL,
    PRIMARY KEY (user_no)
);

CREATE TABLE IF NOT EXISTS orders (
    order_id BIGINT NOT NULL,
    user_no BIGINT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    order_status VARCHAR(20) NOT NULL,
    total_price INTEGER NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (user_no) REFERENCES user (user_no)
);

CREATE TABLE IF NOT EXISTS product (
    product_id BIGINT NOT NULL,
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
    order_product_no INTEGER NOT NULL,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    PRIMARY KEY (order_product_no),
    FOREIGN KEY (order_id) REFERENCES orders (order_id),
    FOREIGN KEY (product_id) REFERENCES product (product_id)
);

CREATE TABLE IF NOT EXISTS admin_account (
    admin_account_no BIGINT NOT NULL,
    admin_id VARCHAR(16) NULL,
    password VARCHAR(16) NULL,
    permission VARCHAR(10) NULL,
    PRIMARY KEY (admin_account_no)
);

CREATE TABLE IF NOT EXISTS refund (
    er_id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    application_date DATE NULL,
    process_status VARCHAR(10) NULL,
    er_reason_type VARCHAR(20) NULL,
    er_reason_detail VARCHAR(300) NULL,
    PRIMARY KEY (er_id),
    FOREIGN KEY (order_id) REFERENCES orders (order_id)
);

CREATE TABLE IF NOT EXISTS refund_product (
    refund_product_no INTEGER NOT NULL,
    order_product_no INTEGER NOT NULL,
    er_id BIGINT NOT NULL,
    PRIMARY KEY (refund_product_no),
    FOREIGN KEY (order_product_no) REFERENCES order_product (order_product_no),
    FOREIGN KEY (er_id) REFERENCES refund (er_id)
);

CREATE TABLE IF NOT EXISTS order_cancel (
    cancel_id VARCHAR(255) NOT NULL,
    cancel_reason VARCHAR(30) NULL,
    order_id BIGINT NOT NULL,
    process_status VARCHAR(20) NULL,
    cancel_date TIMESTAMP NOT NULL,
    PRIMARY KEY (cancel_id),
    FOREIGN KEY (order_id) REFERENCES orders (order_id)
);