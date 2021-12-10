use shopping_bicycle;
drop procedure if EXISTS productSize_create;
DELIMITER $$
CREATE PROCEDURE productSize_create(
    in _size integer,
    in _quantity integer
)
body:

BEGIN
    declare
        newId int;
    SET
        max_sp_recursion_depth = 255;
    if
            (
                select count(product_size.id)
                from product_size
                where product_size.size = _size) > 0 then
        SET @message_text = CONCAT('Product Size \'', _size, '\' already exists');
        SIGNAL
            SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
    else
        insert into product_size(size, quantity,  active_flag, created_date, updated_date)
        values (_size, _quantity, 1, NOW(), NOW());
        set
            newId = last_insert_id();
    end if;
    select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS productSize_update;
DELIMITER $$
CREATE PROCEDURE productSize_update(
    in _size INTEGER,
    in _quantity INTEGER,
    in _active INTEGER
)
body:
begin
    update product_size
    set 
        size = _size,
        quantity = _quantity,
        active_flag   = _active,
        updated_date  = NOW();
END$$
DELIMITER ;

drop procedure if EXISTS productSize_findAll;
DELIMITER $$
CREATE PROCEDURE productSize_findAll()
begin
    select *
    from product_size
    where (active_flag = 1
        or active_flag = 0)
    order by size;
end$$
DELIMITER ;

drop procedure if EXISTS productSize_findById;
DELIMITER $$
CREATE PROCEDURE productSize_findById(in _id int)
begin
    select *
    from product_size
    where id = _id
      and (active_flag = 1
        or active_flag = 0)
    order by size;
end$$
DELIMITER ;

drop procedure if EXISTS productSize_findByQuantity;
DELIMITER $$
CREATE PROCEDURE productSize_findByQuantity(in _quantity integer)
begin
    select *
    from product_size
    where quantity = _quantity
      and (active_flag = 1
        or active_flag = 0)
    order by quantity;
end$$
DELIMITER ;

drop procedure if EXISTS productSize_findBySize;
DELIMITER $$
CREATE PROCEDURE product_findBySize(in _size integer)
begin
    select *
    from product_size
    where size = _size
      and (active_flag = 1
        or active_flag = 0)
    order by size;
end$$
DELIMITER ;