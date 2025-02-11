# Write your MySQL query statement below
SELECT b.name as Employee FROM Employee b INNER JOIN Employee a ON b.managerId = a.id WHERE a.salary < b.salary; 
