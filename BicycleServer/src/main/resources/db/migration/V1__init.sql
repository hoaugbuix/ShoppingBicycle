-- Structure
-- # CREATE DATABASE shopping_bicycle CHARACTER SET utf8 COLLATE utf8_general_ci;
use shopping_bicycle;
SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- -- DROP database shopping_bicycle;

-- -- DROP TABLE user;
CREATE TABLE user
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    first_name   NVARCHAR(100) NOT NULL,
    last_name    NVARCHAR(100) NOT NULL,
    avatar       VARCHAR(255) NOT NULL,
    user_name    VARCHAR(50)  NOT NULL,
    password     VARCHAR(100) NOT NULL,
    email        VARCHAR(100) NOT NULL,
    active_flag  INTEGER      NOT NULL DEFAULT 1,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
-- DROP TABLE user_role;
CREATE TABLE user_role
(
    id           INTEGER   NOT NULL AUTO_INCREMENT,
    user_id      INTEGER   NOT NULL,
    role_id      INTEGER   NOT NULL,
    active_flag  INTEGER   NOT NULL DEFAULT 1,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- DROP TABLE role;
CREATE TABLE role
(
    id           INTEGER     NOT NULL AUTO_INCREMENT,
    role_name    VARCHAR(50) NOT NULL,
    description  NVARCHAR(255) NULL,
    active_flag  INTEGER     NOT NULL DEFAULT 1,
    created_date TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);


-- DROP TABLE notification;
CREATE TABLE notification
(
    id           INTEGER   NOT NULL AUTO_INCREMENT,
    user_id      INTEGER   NOT NULL,
    post_id      INTEGER   NOT NULL,
    task_id      INTEGER   NOT NULL,
    seen         bit(1)    NOT NULL,
    active_flag  INTEGER   NOT NULL DEFAULT 1,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);


-- DROP TABLE image;
CREATE TABLE image
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    link         VARCHAR(255) NOT NULL,
    file_name    VARCHAR(255) NOT NULL,
    size         VARCHAR(255) NOT NULL,
    file_type    VARCHAR(255) NOT NULL,
    post_id      INTEGER      NOT NULL,
    upload_by    NVARCHAR(255) NOT NULL,
    active_flag  INTEGER      NOT NULL DEFAULT 1,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
-- DROP TABLE email;
CREATE TABLE email
(
    id            INTEGER   NOT NULL AUTO_INCREMENT,
    content_email LONGTEXT  NOT NULL,
    seen          bit(1)    NOT NULL,
    active_flag   INTEGER   NOT NULL DEFAULT 1,
    created_date  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- DROP TABLE brand;
CREATE TABLE brand
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    brand_name   VARCHAR(255) NOT NULL,
    thumbnail    VARCHAR(255) NOT NULL,
    active_flag  INTEGER      NOT NULL DEFAULT 1,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- DROP TABLE post;
CREATE TABLE post
(
    id            INTEGER        NOT NULL AUTO_INCREMENT,
    name          VARCHAR(255)   NOT NULL,
    slug          VARCHAR(255)   NOT NULL,
    brand_id      INTEGER        NOT NULL,
    description   NVARCHAR(255) NOT NULL,
    price         DECIMAL(50, 2) NOT NULL,
    product_image VARCHAR(255)   NOT NULL,
    total_sold    INT            NOT NULL,
    public_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active_flag   INTEGER        NOT NULL DEFAULT 1,
    created_date  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by INTEGER NOT NULL ,
    updated_date  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by INTEGER NOT NULL ,
    PRIMARY KEY (id)
);

-- DROP TABLE category;
CREATE TABLE category
(
    id            INTEGER      NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(100) NOT NULL,
    description   NVARCHAR(255) NOT NULL,
    active_flag   INTEGER      NOT NULL DEFAULT 1,
    created_date  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
-- DROP TABLE product;
CREATE TABLE product
(
    id            INTEGER        NOT NULL AUTO_INCREMENT,
    product_name  VARCHAR(100)   NOT NULL,
    description   NVARCHAR(255) NOT NULL,
    slug          VARCHAR(255)   NOT NULL,
    brand_id      INTEGER        NOT NULL,
    price         DECIMAL(50, 2) NOT NULL,
    product_image VARCHAR(255)   NOT NULL,
    total_sold    INT            NOT NULL,
    active_flag   INTEGER        NOT NULL DEFAULT 1,
    created_date  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- DROP TABLE product_category;
CREATE TABLE product_category
(
    id           INTEGER   NOT NULL AUTO_INCREMENT,
    product_id   INTEGER   NOT NULL,
    category_id  INTEGER   NOT NULL,
    active_flag  INTEGER   NOT NULL DEFAULT 1,
    created_by INTEGER NOT NULL ,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by INTEGER NOT NULL ,
    updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- DROP TABLE product_size;
CREATE TABLE product_size
(
    id           INTEGER   NOT NULL AUTO_INCREMENT,
    size         INTEGER   NOT NULL,
    quantity     INTEGER   NOT NULL,
    active_flag  INTEGER   NOT NULL DEFAULT 1,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- DROP TABLE promotio;
CREATE TABLE promotion
(
    id                     INTEGER      NOT NULL AUTO_INCREMENT,
    coupon_code            varchar(255) NOT NULL,
    discount_type          INTEGER      NOT NULL,
    discount_value         INTEGER      NOT NULL,
    maximum_discount_value INTEGER      NOT NULL,
    is_active              BOOLEAN      NOT NULL,
    is_public              BOOLEAN     NOT NULL,
    name                   VARCHAR (255) NOT NULL,
    active_flag            INTEGER      NOT NULL DEFAULT 1,
    created_date           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- DROP TABLE order;
CREATE TABLE orders(
                      id                     INTEGER      NOT NULL AUTO_INCREMENT,
                      note            VARCHAR (255) NOT NULL,
                      product_price          DECIMAL(10,2)     NOT NULL,
                      promotion_id         INTEGER      NOT NULL,
                      promotion json DEFAULT NULL,
                      receiver_address varchar(255) DEFAULT NULL,
                      receiver_name varchar(255) DEFAULT NULL,
                      receiver_phone varchar(255) DEFAULT NULL,
                      size int DEFAULT NULL,
                      status int DEFAULT NULL,
                      total_price    bigint DEFAULT NULL,
                      buyer bigint DEFAULT NULL,
                      created_by bigint DEFAULT NULL,
                      modified_by bigint DEFAULT NULL,
                      product_id varchar(255) DEFAULT NULL,
                      active_flag            INTEGER      NOT NULL DEFAULT 1,
                      created_date           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      updated_date           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      PRIMARY KEY (id)

);

-- DROP TABLE finance;
CREATE TABLE finance (
                         id                     INTEGER      NOT NULL AUTO_INCREMENT,
                         amount            BIGINT NOT NULL,
                         order_id          INTEGER      NOT NULL,
                         active_flag            INTEGER      NOT NULL DEFAULT 1,
                         created_date           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         updated_date           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         PRIMARY KEY (id)
);

-- DROP TABLE configuration;
CREATE TABLE configuration(
                              id                     INTEGER      NOT NULL AUTO_INCREMENT,
                              bicycle_choice           JSON NOT NULL,
                              active_flag            INTEGER      NOT NULL DEFAULT 1,
                              created_date           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              updated_date           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              PRIMARY KEY (id)
);

ALTER TABLE user_role
    ADD CONSTRAINT fk_userRole_user FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE user_role
    ADD CONSTRAINT fk_userRole_role FOREIGN KEY (role_id) REFERENCES role (id);


