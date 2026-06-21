-- Write your PostgreSQL query statement below
select
    t.id as id,
    CASE 
        WHEN t.p_id is NULL THEN 'Root'
        WHEN (select count(*) from Tree t1 where t1.p_id = t.id) >= 1 THEN 'Inner'
        ELSE 'Leaf'
    END as type
from Tree t
;
