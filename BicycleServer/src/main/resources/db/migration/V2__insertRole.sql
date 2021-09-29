-- use shopping_bicycle;
LOCK TABLES `role` WRITE;
INSERT INTO role(role_name, description)
VALUES ('admin', 'Admin of system'),
       ('staff', 'Staff of system'),
       ('user', 'User of system'),
       ('manager', 'Manager of system');

UNLOCK TABLES;