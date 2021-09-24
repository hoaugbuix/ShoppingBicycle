-- Structure
-- # CREATE DATABASE management_work CHARACTER SET utf8 COLLATE utf8_general_ci;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- drop database management_work;
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


CREATE TABLE role
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    role_name    VARCHAR(50)  NOT NULL,
    description  NVARCHAR(255) NULL,
    active_flag  INTEGER      NOT NULL DEFAULT 1,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);



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

CREATE TABLE post
(
    id                INTEGER       NOT NULL AUTO_INCREMENT,
    title             NVARCHAR(255) NOT NULL,
    short_description TEXT          NOT NULL,
    content           LONGTEXT      NOT NULL,
    user_id           INTEGER       NOT NULL,
    active_flag       INTEGER       NOT NULL DEFAULT 1,
    created_date      TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date      TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE comment
(
    id           INTEGER    NOT NULL AUTO_INCREMENT,
    content      TEXT       NOT NULL,
    user_id      INTEGER    NOT NULL,
    post_id      INTEGER    NOT NULL,
    rate         BIGINT(20) NOT NULL,
    active_flag  INTEGER    NOT NULL DEFAULT 1,
    created_date TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE image
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    data         LONGBLOB     NOT NULL,
    file_name    VARCHAR(255) NOT NULL,
    file_type    VARCHAR(255) NOT NULL,
    post_id      INTEGER      NOT NULL,
    active_flag  INTEGER      NOT NULL DEFAULT 1,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE email
(
    id           INTEGER   NOT NULL AUTO_INCREMENT,
    content_email LONGTEXT NOT NULL,
    seen         bit(1)    NOT NULL,
    active_flag  INTEGER   NOT NULL DEFAULT 1,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE department
(
    id              INTEGER      NOT NULL AUTO_INCREMENT,
    department_name VARCHAR(255) NOT NULL,
    description     VARCHAR(255) NULL,
    user_id         INTEGER NOT NULL,
    active_flag     INTEGER      NOT NULL DEFAULT 1,
    created_date    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE task
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    task_name    VARCHAR(50)  NOT NULL,
    description  VARCHAR(255) NULL,
    action_name  bigint(20)   NOT NULL,
    user_id      INTEGER      NOT NULL,
    active_flag  INTEGER      NOT NULL DEFAULT 1,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);


# foreign key
ALTER TABLE user_role
    ADD CONSTRAINT fk_userRole_user FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE user_role
    ADD CONSTRAINT fk_userRole_role FOREIGN KEY (role_id) REFERENCES role (id);
ALTER TABLE image
    ADD CONSTRAINT fk_image_post FOREIGN KEY (post_id) REFERENCES post (id);
ALTER TABLE comment
    ADD CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE comment
    ADD CONSTRAINT fk_comment_post FOREIGN KEY (post_id) REFERENCES post (id);
ALTER TABLE post
    ADD CONSTRAINT fk_post_user FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE notification
    ADD CONSTRAINT fk_notification_user FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE notification
    ADD CONSTRAINT fk_notification_post FOREIGN KEY (post_id) REFERENCES post (id);
ALTER TABLE notification
    ADD CONSTRAINT fk_notification_task FOREIGN KEY (task_id) REFERENCES task (id);
