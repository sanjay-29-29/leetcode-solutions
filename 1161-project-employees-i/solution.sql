# Write your MySQL query statement below
SELECT project_id, round(avg(experience_years),2) as average_years 
FROM Project p
Inner join Employee e
on p.employee_id = e.employee_id
group by project_id; 
