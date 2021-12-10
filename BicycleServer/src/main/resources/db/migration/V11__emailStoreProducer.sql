drop procedure if EXISTS email_create;
DELIMITER $$
CREATE PROCEDURE email_create(in _contentEmail VARCHAR(255),
                              in _seen BIT)
body:
BEGIN
    declare
        newId int;
    SET
        max_sp_recursion_depth = 255;
    if (
           select count(email.id)
           from email
           where email.content_email = _contentEmail) > 0 then
        SET @message_text = CONCAT('Email \'', '_contentEmail', '\' already exists');
        SIGNAL
            SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
    else
        insert into email(content_email, seen, active_flag, created_date, updated_date)
        values (_contentEmail, _seen, 1, now(), now());
        set
            newId = last_insert_id();
    end if;
    select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS email_update;
DELIMITER $$
CREATE PROCEDURE email_update(in _contentEmail VARCHAR(255),
                              in _seen BIT,
                              in _active_flag INTEGER)
body:
begin
    update email
    set content_email = _contentEmail,
        seen          = _seen,
        active_flag   = _active_flag,
        updated_date  = now();
END$$
DELIMITER ;
--

drop procedure if EXISTS email_findAll;
DELIMITER $$
CREATE PROCEDURE email_findAll()
begin
    select *
    from email
    where active_flag = 1
       or active_flag = 0;
end$$
DELIMITER ;


drop procedure if EXISTS email_findById;
DELIMITER $$
CREATE PROCEDURE email_findById(in _id int)
begin
    select *
    from email
    where id = _id
      and (active_flag = 1
        or active_flag = 0)
    order by content_email;
end$$
DELIMITER ;

drop procedure if EXISTS email_findlByContentEmail;
DELIMITER $$
CREATE PROCEDURE email_findlByContentEmail(in _content varchar(255))
begin
    select *
    from email
    where content_email = _content
      and (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;


drop procedure if EXISTS email_findBySeen;
DELIMITER $$
CREATE PROCEDURE email_findBySeen(in _seen BIT)
begin
    select 1
    from email
    where seen = _seen
      and (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;