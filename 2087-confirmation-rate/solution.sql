# Write your MySQL query statement below
select 
    -- *
    s.user_id, 
    if(c.user_id IS NULL, 0, round(c.confirm_count / c.total_count, 2)) as confirmation_rate
from Signups s
left join (
    select 
        user_id, 
        count(case when action = 'confirmed' then 1 else null end) as confirm_count,
        count(*) as total_count
    from Confirmations
    group by user_id    
) as c
on c.user_id = s.user_id;
