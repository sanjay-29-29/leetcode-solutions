# Write your MySQL query statement below
SELECT email FROM (
    SELECT email, COUNT(*) as count FROM Person
    GROUP BY email
) as T WHERE count >= 2;
