# Write your MySQL query statement below
select product_id, if(average_price IS null, 0, average_price) as average_price 
from
(
    select p.product_id, 
    round(sum(price * units) / sum(units), 2) as average_price 
    from Prices p
    left join UnitsSold u
    on u.product_id = p.product_id
    and u.purchase_date >= start_date
    and u.purchase_date <= end_date
    group by p.product_id
) as t;
