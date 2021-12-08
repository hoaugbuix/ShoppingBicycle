drop procedure if EXISTS brand_create;
DELIMITER $$
CREATE PROCEDURE brand_create(
    in _brandName VARCHAR(255),
    in _thumbnail VARCHAR(255)
)
body:
BEGIN
    declare
        newId int;
    SET
        max_sp_recursion_depth = 255;
    if
            (
                select count(brand.id)
                from brand
                where brand.brand_name = _brandName) > 0 then
        SET @message_text = CONCAT('Image \'', _brandName, '\' already exists');
        SIGNAL
            SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
    else
        insert into brand(brand_name, thumbnail, active_flag, created_date, updated_date)
        values (_brandName, _thumbnail, 1, now(), now());
        set
            newId = last_insert_id();
    end if;
    select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS brand_update;
DELIMITER $$
CREATE PROCEDURE brand_update(
    in _id INTEGER,
    in _brandName VARCHAR(255),
    in _thumbnail VARCHAR(255),
    in _active INTEGER
)
body:
begin
    update brand
    set id = _id,
        brand_name = _brandName,
        thumbnail =  _thumbnail,
        active_flag = _active
    WHERE id = _id;
END$$
DELIMITER ;
--

drop procedure if EXISTS brand_findAll;
DELIMITER $$
CREATE PROCEDURE brand_findAll()
begin
    select *
    from brand
    where active_flag = 1
       or active_flag = 0;
end$$
DELIMITER ;


drop procedure if EXISTS brand_findById;
DELIMITER $$
CREATE PROCEDURE brand_findById(in _id int)
begin
    select *
    from brand
    where id = _id
      and (active_flag = 1
        or active_flag = 0)
    order by brand_name;
end$$
DELIMITER ;

drop procedure if EXISTS brand_findByBrandName;
DELIMITER $$
CREATE PROCEDURE brand_findByBrandName(in _brandName varchar(100))
begin
    select *
    from brand
    where brand_name = _brandName
      and (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;

