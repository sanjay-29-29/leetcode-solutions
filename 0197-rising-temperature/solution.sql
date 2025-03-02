# Write your MySQL query statement below
select id from (
    select 
    if(a.temperature < b.temperature, b.id, null) as id
    -- * 
    from Weather a
    left join Weather b
    on datediff(a.recordDate, b.recordDate) = -1
) as t
where id is not null;
