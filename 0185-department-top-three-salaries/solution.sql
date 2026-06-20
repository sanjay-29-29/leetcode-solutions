-- Write your PostgreSQL query statement below
SELECT 
    d.name as Department,
    e.name as Employee,
    e.salary as Salary
FROM
    Employee e
JOIN
    Department d
ON 
    e.departmentId = d.id
WHERE
    e.salary
    IN (
        select e1.salary from employee e1
        where e.departmentId = e1.departmentId
        group by e1.salary order by e1.salary DESC LIMIT 3
    )
;
