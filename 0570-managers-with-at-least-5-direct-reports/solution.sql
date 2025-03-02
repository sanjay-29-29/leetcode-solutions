# Write your MySQL query statement below
select t.name from( 
    select e.name, count(*) as sub_count from Employee e
    join Employee n 
    on e.id = n.managerId
    group by n.managerId
) as t 
where sub_count >= 5;
