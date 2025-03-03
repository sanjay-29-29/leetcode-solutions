# Write your MySQL query statement below
select * from
(
    select u.name as results
    from MovieRating m 
    left join Users u on u.user_id = m.user_id
    group by m.user_id
    order by count(rating) desc, u.name
    limit 1
) as t2
union all
select * 
from (
    select t.title as results
    from MovieRating m
    left join Movies t
    on t.movie_id = m.movie_id
    where created_at >= '2020-02-01' and created_at <= '2020-02-28'
    group by m.movie_id
    order by avg(rating) desc, t.title
    limit 1
) as t1;

