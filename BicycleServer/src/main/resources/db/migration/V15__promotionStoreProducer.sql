use shopping_bicycle;
drop procedure if EXISTS promotion_create;
DELIMITER $$
CREATE PROCEDURE promotion_create (
    in _name varchar(255),
    in _couponCode varchar(255),
    in _discountType INTEGER,
    in _discountValue INTEGER,
    in _maximumDiscountValue INTEGER,
    in _isAcitve BOOLEAN,
    in _isPublic BOOLEAN
)
body:

BEGIN
    declare
        newId int;
    SET
        max_sp_recursion_depth = 255;
    if
            (
                select count(id)
                from promotion
                where coupon_code = _couponCode) > 0 then
        SET @message_text = CONCAT('promotion \'', _couponCode, '\' already exists');
        SIGNAL
            SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
    else
        insert into promotion(name, coupon_code, discount_type, discount_value, maximum_discount_value, is_active, is_public, active_flag, created_date, updated_date)
        values (_name, _couponCode, _discountType, _discountValue, _maximumDiscountValue, _isAcitve, _isPublic, 1, NOW(), NOW());
        set
            newId = last_insert_id();
    end if;
    select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS promotion_update;
DELIMITER $$
CREATE PROCEDURE promotion_update(
    in _name varchar(255),
    in _couponCode varchar(255),
    in _discountType INTEGER,
    in _discountValue INTEGER,
    in _maximumDiscountValue INTEGER,
    in _isAcitve BOOLEAN,
    in _isPublic BOOLEAN,
    in _active INTEGER
)
body:
begin
    update promotion
    set 
        name = _name,
        coupon_code = _couponCode,
        discount_type = _discountType,
        discount_value = _discountValue,
        maximum_discount_value = _maximumDiscountValue,
        is_active = _isAcitve ,
        is_public = _isPublic,
        active_flag   = _active,
        updated_date  = NOW();
END$$
DELIMITER ;

drop procedure if EXISTS promotion_findAll;
DELIMITER $$
CREATE PROCEDURE promotion_findAll()
begin
    select *
    from promotion
    where (active_flag = 1
        or active_flag = 0)
    order by coupon_code;
end$$
DELIMITER ;

drop procedure if EXISTS promotion_findById;
DELIMITER $$
CREATE PROCEDURE promotion_findById(in _id int)
begin
    select *
    from promotion
    where id = _id
      and (active_flag = 1
        or active_flag = 0)
    order by coupon_code;
end$$
DELIMITER ;

drop procedure if EXISTS promotion_findByCouponCode;
DELIMITER $$
CREATE PROCEDURE promotion_findByCouponCode(in _couponCode varchar(255))
begin
    select *
    from promotion
    where coupon_code = _couponCode
      and (active_flag = 1
        or active_flag = 0)
    order by coupon_code;
end$$
DELIMITER ;
