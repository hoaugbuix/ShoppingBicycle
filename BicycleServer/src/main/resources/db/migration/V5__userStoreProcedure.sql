use
management_work;

drop procedure if EXISTS user_findAll;
DELIMITER
$$
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
DELIMITER
$$
CREATE PROCEDURE user_findById(in _id int)
begin
select *
from user
where id = _id and(active_flag = 1
    or active_flag = 0)
order by first_name;
end$$
DELIMITER ;

