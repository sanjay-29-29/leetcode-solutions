-- Write your PostgreSQL query statement below
SELECT d.name as Department, e.name as Employee, e.salary as Salary 
FROM Employee e 
JOIN Department d
ON e.departmentId = d.id
WHERE e.salary IN (
    SELECT e2.salary 
    FROM Employee e2
    WHERE 
        e2.departmentId = e.departmentId
    ORDER BY e2.salary DESC
    LIMIT 1
);
