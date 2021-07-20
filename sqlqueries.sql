delimiter //
create procedure getFoodCount()
beign 
SELECT food_inventory.food_name, COUNT(order_table.food_id) AS QTY FROM order_table,food_inventory WHERE food_inventory.food_id=order_table.food_id GROUP BY order_table.food_id;

end//


delimiter //
create trigger getFoodCountTrigger
after insert on order_table for each row
beign 
    declare foodname varchar(30);
    declare foodqty int default 0;
    declare fooddate datetime;
    
SELECT food_inventory.food_name into foodname, COUNT(order_table.food_id) AS QTY into foodqty, order_table.order_date
AS DateF into fooddate FROM order_table,food_inventory WHERE food_inventory.food_id=order_table.food_id GROUP BY order_table.food_id, order_table.order_date;

update order_count set count = foodqty, date = fooddate where food_name =foodname; 

end//



CREATE VIEW  orderuserdetails AS SELECT order_table.order_id,order_table.food_type,order_table.is_cancel,order_table.is_done,
order_table.order_date,food_inventory.food_name,user.user_name,user.user_id FROM order_table,food_inventory,
user WHERE order_table.food_id=food_inventory.food_id AND order_table.user_id=user.user_id AND order_table.order_date = CURRENT_DATE()


delimiter //
CREATE trigger orderdetailscount
after insert on order_table for each row

begin

    declare foodname varchar(30);
    declare foodtype varchar(30);
    declare foodqty int default 0;
    
SELECT f.category_type into foodtype, COUNT(o.food_id) into foodqty, f.food_name into foodname FROM
order_table o, food_inventory f WHERE o.order_date=curdate() and o.food_id=f.food_id GROUP by f.food_id;

INSERT INTO order_count(count,date,food_name,foodtype)
VALUE(foodqty,CURRENT_DATE(),foodname,foodtype);

end//

delimiter ;


create index order_index on order_table(order_id);
create index food_index on food_inventory(food_id);
create index user_index on user(user_id);




SHOW INDEX FROM food_inventory;



delimiter //
create procedure order_issue(in o_id int)
begin
UPDATE `order_table` SET is_done = '1' WHERE `order_id` = o_id;
end//






