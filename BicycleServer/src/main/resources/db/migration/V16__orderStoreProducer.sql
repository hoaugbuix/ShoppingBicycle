use shopping_bicycle;
drop procedure if EXISTS order_create;
DELIMITER $$
CREATE PROCEDURE order_create(_note VARCHAR(255),
                              _product_price DECIMAL(10, 2),
                              _promotion_id INTEGER,
                              _product_id INTEGER,
                              _product_size INTEGER,
                              _receiver_address varchar(255),
                              _receiver_name varchar(255),
                              _receiver_phone varchar(255),
                              _status varchar(255),
                              _total_price bigint,
                              _buyer bigint,
                              _created_by bigint,
                              _modified_by bigint)
body:

BEGIN
    declare
        newId int;
    SET
        max_sp_recursion_depth = 255;
    if
            (
                select count(id)
                from orders
                where note = _note) > 0 then
        SET @message_text = CONCAT('order \'', _note, '\' already exists');
        SIGNAL
            SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
    else
        insert into orders(note,
                           product_price,
                           promotion_id,
                           product_id,
                           product_size,
                           receiver_address,
                           receiver_name,
                           receiver_phone,
                           status,
                           total_price,
                           buyer,
                           created_by,
                           modified_by,
                           active_flag,
                           created_date,
                           updated_date)
        values (_note,
                _product_price,
                _promotion_id,
                _product_id,
                _product_size,
                _receiver_address,
                _receiver_name,
                _receiver_phone,
                _status,
                _total_price,
                _buyer,
                _created_by,
                _modified_by,
                1,
                NOW(),
                NOW());
        set
            newId = last_insert_id();
    end if;
    select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS order_update;
DELIMITER $$
CREATE PROCEDURE order_update(in _note VARCHAR(255),
                              in _product_price DECIMAL(10, 2),
                              in _promotion_id INTEGER,
                              in _product_id INTEGER,
                              in _product_size INTEGER,
                              in _receiver_address varchar(255),
                              in _receiver_name varchar(255),
                              in _receiver_phone varchar(255),
                              in _status varchar(255),
                              in _total_price bigint,
                              in _buyer bigint,
                              in _created_by bigint,
                              in _modified_by bigint,
                              in _active INTEGER)
body:
begin
    update orders
    set note             = _note,
        product_price    = _product_price,
        promotion_id     = _promotion_id,
        product_id       = _product_id,
        product_size     = _product_size,
        receiver_address = _receiver_name,
        receiver_name    = _receiver_name,
        receiver_phone   = _receiver_phone,
        receiver_address = _receiver_address,
        status           = _status,
        total_price      = _total_price,
        buyer            = _buyer,
        created_by       = _created_by,
        modified_by      = _modified_by,
        active_flag      = _active,
        updated_date     = NOW();
END$$
DELIMITER ;

drop procedure if EXISTS order_findAll;
DELIMITER $$
CREATE PROCEDURE order_findAll()
begin
    select *
    from orders
    where (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;

drop procedure if EXISTS order_findById;
DELIMITER $$
CREATE PROCEDURE order_findById(in _id int)
begin
    select *
    from orders
    where id = _id
      and (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;

drop procedure if EXISTS order_findByNote;
DELIMITER $$
CREATE PROCEDURE order_findByNote(in _note Varchar(255))
begin
    select *
    from orders
    where note = _note
      and (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;

drop procedure if EXISTS order_findByStatusAndProductId;
DELIMITER $$
CREATE PROCEDURE order_findByStatusAndProductId(in _status Varchar(255), in _productId int)
begin
    select *
    from orders
    where status = _status and product_id = _productId
      and (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;

