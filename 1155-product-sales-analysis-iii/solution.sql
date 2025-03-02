# Write your MySQL query statement below
select t1.product_id, first_year, quantity, price
from 
    (
        select s.product_id, s.year as first_year, s.quantity, s.price
        from Sales s
        inner join Product p
        on s.product_id = p.product_id
    ) as t1
inner join (
    select product_id, min(year) as min_year
    from Sales
    group by product_id
) as t2
where t1.product_id = t2.product_id and t1.first_year = t2.min_year;

