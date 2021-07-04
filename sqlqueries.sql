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
    
SELECT food_inventory.food_name into foodname, COUNT(order_table.food_id) AS QTY into foodqty, order_table.order_date AS DateF into fooddate FROM order_table,food_inventory WHERE food_inventory.food_id=order_table.food_id GROUP BY order_table.food_id, order_table.order_date;

update order_count set count = foodqty, date = fooddate where food_name =foodname; 

end//







