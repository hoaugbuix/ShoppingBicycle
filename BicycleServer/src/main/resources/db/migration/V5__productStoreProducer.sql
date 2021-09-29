

drop procedure if EXISTS product_findAll;
DELIMITER $$
CREATE PROCEDURE product_findAll()
begin
    select *
    from product
    where (active_flag = 1
        or active_flag = 0)
    order by product_name;
end$$
DELIMITER ;

drop procedure if EXISTS product_findById;
DELIMITER $$
CREATE PROCEDURE product_findById(in _id int)
begin
    select *
    from product
    where id = _id
      and (active_flag = 1
        or active_flag = 0)
    order by product_code;
end$$
DELIMITER ;

drop procedure if EXISTS product_findByCode;
DELIMITER $$
CREATE PROCEDURE product_findByCode(in _code varchar(50))
begin
    select *
    from product
    where product_code = _code
      and (active_flag = 1
        or active_flag = 0)
    order by product_code;
end$$
DELIMITER ;