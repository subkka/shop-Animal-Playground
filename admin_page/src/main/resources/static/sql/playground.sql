DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `user_no`	BIGINT	NOT NULL,
                        `user_name`	VARCHAR(30)	NULL,
                        `user_email`	VARCHAR(30)	NULL,
                        `user_email_able`	BOOLEAN	NULL,
                        `address`	VARCHAR(30)	NULL,
                        `join_date`	DATE	NULL,
                        `last_connect`	DATE	NULL,
                        `user_pet`	VARCHAR(20)	NULL
);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
                          `order_id`	BIGINT	NOT NULL,
                          `user_no`	BIGINT	NOT NULL,
                          `order_date`	TIMESTAMP	NOT NULL,
                          `order_status`	VARCHAR(20)	NOT NULL,
                          `total_price`	INTEGER	NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
                           `product_id`	BIGINT	NOT NULL,
                           `product_name`	VARCHAR(30)	NULL,
                           `category`	VARCHAR(10)	NULL,
                           `product_image`	BLOB	NULL,
                           `product_desc`	VARCHAR(30)	NULL,
                           `price`	INT	NULL,
                           `amount`	INT	NULL,
                           `is_display`	BOOLEAN	NULL,
                           `product_status`	VARCHAR(10)	NULL,
                           `created_at`	DATE	NULL
);

DROP TABLE IF EXISTS `order_product`;

CREATE TABLE `order_product` (
                                 `order_product_no`	INTEGER	NOT NULL,
                                 `order_id`	BIGINT	NOT NULL,
                                 `product_id`	BIGINT	NOT NULL,
                                 `quantity`	INTEGER	NOT NULL
);

DROP TABLE IF EXISTS `admin_account`;

CREATE TABLE `admin_account` (
                                 `admin_account_no`	BIGINT	NOT NULL,
                                 `admin_id`	VARCHAR(16)	NULL,
                                 `password`	VARCHAR(16)	NULL,
                                 `permission`	VARCHAR(10)	NULL
);

DROP TABLE IF EXISTS `refund`;

CREATE TABLE `refund` (
                          `er_id`	BIGINT	NOT NULL,
                          `order_id`	BIGINT	NOT NULL,
                          `application_date`	DATE	NULL,
                          `process_status`	VARCHAR(10)	NULL,
                          `er_reason_type`	VARCHAR(20)	NULL,
                          `er_reason_detail`	VARCHAR(300)	NULL
);

DROP TABLE IF EXISTS `refund_product`;

CREATE TABLE `refund_product` (
                                  `refund_product_no`	INTEGER	NOT NULL,
                                  `order_product_no`	INTEGER	NOT NULL,
                                  `er_id`	BIGINT	NOT NULL
);

DROP TABLE IF EXISTS `order_cancel`;

CREATE TABLE `order_cancel` (
                                `cancel_id`	VARCHAR(255)	NOT NULL,
                                `cancel_reason`	varchar(30)	NULL,
                                `order_id`	BIGINT	NOT NULL,
                                `process_stastus`	VARCHAR(20)	NULL,
                                `cancel_date`	TIMESTAMP	NOT NULL
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
                                                         `user_no`
    );

ALTER TABLE `orders` ADD CONSTRAINT `PK_ORDERS` PRIMARY KEY (
                                                             `order_id`
    );

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
                                                               `product_id`
    );

ALTER TABLE `order_product` ADD CONSTRAINT `PK_ORDER_PRODUCT` PRIMARY KEY (
                                                                           `order_product_no`
    );

ALTER TABLE `admin_account` ADD CONSTRAINT `PK_ADMIN_ACCOUNT` PRIMARY KEY (
                                                                           `admin_account_no`
    );

ALTER TABLE `refund` ADD CONSTRAINT `PK_REFUND` PRIMARY KEY (
                                                             `er_id`
    );

ALTER TABLE `refund_product` ADD CONSTRAINT `PK_REFUND_PRODUCT` PRIMARY KEY (
                                                                             `refund_product_no`
    );

ALTER TABLE `order_cancel` ADD CONSTRAINT `PK_ORDER_CANCEL` PRIMARY KEY (
                                                                         `cancel_id`
    );

ALTER TABLE `orders` ADD CONSTRAINT `FK_user_TO_orders_1` FOREIGN KEY (
                                                                       `user_no`
    )
    REFERENCES `user` (
                       `user_no`
        );

ALTER TABLE `order_product` ADD CONSTRAINT `FK_orders_TO_order_product_1` FOREIGN KEY (
                                                                                       `order_id`
    )
    REFERENCES `orders` (
                         `order_id`
        );

ALTER TABLE `order_product` ADD CONSTRAINT `FK_product_TO_order_product_1` FOREIGN KEY (
                                                                                        `product_id`
    )
    REFERENCES `product` (
                          `product_id`
        );

ALTER TABLE `refund` ADD CONSTRAINT `FK_orders_TO_refund_1` FOREIGN KEY (
                                                                         `order_id`
    )
    REFERENCES `orders` (
                         `order_id`
        );

ALTER TABLE `refund_product` ADD CONSTRAINT `FK_order_product_TO_refund_product_1` FOREIGN KEY (
                                                                                                `order_product_no`
    )
    REFERENCES `order_product` (
                                `order_product_no`
        );

ALTER TABLE `refund_product` ADD CONSTRAINT `FK_refund_TO_refund_product_1` FOREIGN KEY (
                                                                                         `er_id`
    )
    REFERENCES `refund` (
                         `er_id`
        );

ALTER TABLE `order_cancel` ADD CONSTRAINT `FK_orders_TO_order_cancel_1` FOREIGN KEY (
                                                                                     `order_id`
    )
    REFERENCES `orders` (
                         `order_id`
        );

