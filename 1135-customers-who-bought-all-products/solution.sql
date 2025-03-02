select customer_id from
(
    select customer_id, count(distinct product_key) as order_count 
    from Customer
    group by customer_id
) as c
where order_count = (
    select count(product_key) 
    from Product
);
