drop procedure if EXISTS image_create;
DELIMITER $$
CREATE PROCEDURE image_create(
    in _link VARCHAR(255),
    in _fileName VARCHAR(100),
    in _fileType VARCHAR(255),
    in _size LONG,
    in _postID LONG,
    in _uploadBy LONG
)
body:
BEGIN
    declare
        newId int;
    SET
        max_sp_recursion_depth = 255;
    if
            (
                select count(image.id)
                from image
                where image.file_name) > 0 then
        SET @message_text = CONCAT('Image \'', _fileName, '\' already exists');
        SIGNAL
            SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
    else
        insert into image(link, file_name, size, file_type, post_id, upload_by, active_flag, created_date, updated_date)
        values (_link, _fileName, _size, _fileType, _postID, _uploadBy, 1, now(), now());
        set
            newId = last_insert_id();
    end if;
    select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS image_update;
DELIMITER $$
CREATE PROCEDURE image_update(
    in _link VARCHAR(255),
    in _fileName VARCHAR(100),
    in _fileType VARCHAR(255),
    in _size VARCHAR(255),
    in _postID int,
    in _uploadBy int
)
body:
begin
    update image
    set link = _link,
        file_name = _fileName,
        size   = _size,
        file_type   = _fileType,
        post_id  = _postID,
        upload_by = _uploadBy;
END$$
DELIMITER ;
--

drop procedure if EXISTS image_findAll;
DELIMITER $$
CREATE PROCEDURE image_findAll()
begin
    select *
    from image
    where active_flag = 1
       or active_flag = 0;
end$$
DELIMITER ;


drop procedure if EXISTS image_findById;
DELIMITER $$
CREATE PROCEDURE image_findById(in _id int)
begin
    select *
    from image
    where id = _id
      and (active_flag = 1
        or active_flag = 0)
    order by file_name;
end$$
DELIMITER ;

drop procedure if EXISTS image_findByLink;
DELIMITER $$
CREATE PROCEDURE image_findByLink(in _link varchar(100))
begin
    select *
    from image
    where link = _link
      and (active_flag = 1
        or active_flag = 0);
end$$
DELIMITER ;


# drop procedure if EXISTS category_checkProductInCategory;
# DELIMITER $$
# CREATE PROCEDURE category_checkProductInCategory(in _id int)
# begin
#     select 1
#     from product_info
#     where cate_id = _id
#       and (active_flag = 1
#         or active_flag = 0);
# end$$
# DELIMITER ;