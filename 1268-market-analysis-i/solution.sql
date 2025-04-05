# Write your MySQL query statement below
SELECT 
    user_id as buyer_id, 
    join_date, 
    coalesce(t.orders_in_2019, 0) as orders_in_2019
FROM Users 
LEFT JOIN (
    SELECT buyer_id, COUNT(*) as orders_in_2019
    FROM Orders
    WHERE YEAR(order_date) = 2019
    GROUP BY buyer_id
) as t
ON Users.user_id = t.buyer_id;
