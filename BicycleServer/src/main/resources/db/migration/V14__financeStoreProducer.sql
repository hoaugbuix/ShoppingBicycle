use shopping_bicycle;
drop procedure if EXISTS finance_create;
DELIMITER $$
CREATE PROCEDURE finance_create(in _amount integer,
                                in _orderId integer)
body:

BEGIN
    declare
        newId int;
    SET
        max_sp_recursion_depth = 255;
    if
            (
                select count(id)
                from finance
                where amount = _amount) > 0 then
        SET @message_text = CONCAT('Finance \'', _amount, '\' already exists');
        SIGNAL
            SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
    else
        insert into finance(amount, order_id, active_flag, created_date, updated_date)
        values (_amount, _orderId, 1, NOW(), NOW());
        set
            newId = last_insert_id();
    end if;
    select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS finance_update;
DELIMITER $$
CREATE PROCEDURE finance_update(in _amount integer,
                                in _orderId integer,
                                in _active INTEGER)
body:
begin
    update finance
    set amount       = _amount,
        order_id     = _orderId,
        active_flag  = _active,
        updated_date = NOW();
END$$
DELIMITER ;

drop procedure if EXISTS finance_findAll;
DELIMITER $$
CREATE PROCEDURE finance_findAll()
begin
    select *
    from finance
    where (active_flag = 1
        or active_flag = 0)
    order by amount;
end$$
DELIMITER ;

drop procedure if EXISTS finance_findById;
DELIMITER $$
CREATE PROCEDURE finance_findById(in _id int)
begin
    select *
    from finance
    where id = _id
      and (active_flag = 1
        or active_flag = 0)
    order by amount;
end$$
DELIMITER ;

drop procedure if EXISTS finance_findByAmount;
DELIMITER $$
CREATE PROCEDURE finance_findByAmount(in _amount integer)
begin
    select *
    from finance
    where amount = _amount
      and (active_flag = 1
        or active_flag = 0)
    order by amount;
end$$
DELIMITER ;

-- drop procedure if EXISTS finance_findBy;
-- DELIMITER $$
-- CREATE PROCEDURE product_findBySize(in _size integer)
-- begin
--     select *
--     from product_size
--     where size = _size
--       and (active_flag = 1
--         or active_flag = 0)
--     order by size;
-- end$$
-- DELIMITER ;