drop procedure if EXISTS post_create;
DELIMITER $$
CREATE PROCEDURE post_create(
    in _content VARCHAR(255),
    in _title VARCHAR(255),
    in _slug VARCHAR(255),
    in _thumbnail VARCHAR(255),
    in _description VARCHAR(255),
    in _createdBy INTEGER,
    in _updatedBy INTEGER
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
                from post
                where title = _title) > 0 then
        SET @message_text = CONCAT('Post \'', _title, '\' already exists');
        SIGNAL
            SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
    else
        insert into post(content, title, slug, thumbnail, description, created_by, updated_by, active_flag, created_date, updated_date)
        values (_content, _title, _slug, _thumbnail, _description, _createdBy, _updatedBy, 1, NOW(), NOW());
        set
            newId = last_insert_id();
    end if;
    select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS post_update;
DELIMITER $$
CREATE PROCEDURE post_update(
    in _content VARCHAR(255),
    in _title VARCHAR(100),
    in _slug VARCHAR(255),
    in _thumbnail VARCHAR(255),
    in _description VARCHAR(255),
    in _updatedBy INTEGER,
    in _active_flag INTEGER
)
body:
begin
    update post
    set content = _content,
        title = _title,
        slug = _slug,
        thumbnail = _thumbnail,
        description   = _description,
        active_flag   = _active_flag,
        updated_by = _updatedBy,
        updated_date  = NOW();
END$$
DELIMITER ;
--

drop procedure if EXISTS post_findAll;
DELIMITER $$
CREATE PROCEDURE post_findAll()
begin
    select *
    from post
    where active_flag = 1
       or active_flag = 0;
end$$
DELIMITER ;


drop procedure if EXISTS post_findById;
DELIMITER $$
CREATE PROCEDURE post_findById(in _id int)
begin
    select *
    from post
    where id = _id
      and (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;

drop procedure if EXISTS post_findByContent;
DELIMITER $$
CREATE PROCEDURE post_findByContent(in _content varchar(100))
begin
    select *
    from post
    where content = _content
      and (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;


drop procedure if EXISTS post_findByTitle;
DELIMITER $$
CREATE PROCEDURE post_findByTitle(in _title varchar(100))
begin
    select *
    from post
    where title = _title
      and (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;
