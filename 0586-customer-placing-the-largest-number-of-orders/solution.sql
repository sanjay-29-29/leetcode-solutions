# Write your MySQL query statement below
SELECT (customer_number) as customer_number FROM
(
    SELECT COUNT(*) AS 
    order_count, customer_number 
    FROM Orders GROUP BY customer_number
    ORDER BY order_count DESC LIMIT 1
) AS t;
