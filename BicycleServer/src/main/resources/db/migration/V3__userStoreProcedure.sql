drop procedure if EXISTS user_create;
DELIMITER $$
CREATE PROCEDURE user_create(
    in _first_name VARCHAR(100),
    in _last_name VARCHAR(100),
    in _avatar VARCHAR(255),
    in _user_name VARCHAR(50),
    in _password VARCHAR(100),
    in _email VARCHAR(100)
)
body:
BEGIN
    declare
        newId int;
    SET
        max_sp_recursion_depth = 255;
    if
            (
                select count(user.id)
                from user
                where user.email = _email) > 0 then
        SET @message_text = CONCAT('User name \'', _email, '\' already exists');
        SIGNAL
            SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
    else
        insert into user(first_name, last_name, avatar, user_name, password, email, active_flag, created_date,
                         updated_date)
        values (_first_name, _last_name, _avatar, _user_name, _password, _email, 1, NOW(), NOW());
        -- select id from user where email = _email and user_name = _user_name;
        set
            newId = last_insert_id();
    end if;
    select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS user_update;
DELIMITER $$
CREATE PROCEDURE user_update(
    in _first_name VARCHAR(100),
    in _last_name VARCHAR(100),
    in _avatar VARCHAR(255),
    in _user_name VARCHAR(50),
    in _password VARCHAR(100),
    in _email VARCHAR(100)
)
body:
begin
    update user
    set first_name   = _first_name,
        last_name    = _last_name,
        avatar       = _avatar,
        user_name    = _user_name,
        password     = _password,
        email        = _email,
        active_flag  = 1,
        updated_date = NOW();
END$$
DELIMITER ;

drop procedure if EXISTS user_findAll;
DELIMITER $$
CREATE PROCEDURE user_findAll()
begin
    select *
    from user
    where (active_flag = 1
        or active_flag = 0)
    order by first_name;
end$$
DELIMITER ;

drop procedure if EXISTS user_findById;
DELIMITER $$
CREATE PROCEDURE user_findById(in _id int)
begin
    select *
    from user
    where id = _id
      and (active_flag = 1
        or active_flag = 0)
    order by first_name;
end$$
DELIMITER ;

drop procedure if EXISTS user_findByEmail;
DELIMITER $$
CREATE PROCEDURE user_findByEmail(in _email varchar(100))
begin
    select *
    from user
    where email = _email
      and (active_flag = 1
        or active_flag = 0)
    order by first_name;
end$$
DELIMITER ;

