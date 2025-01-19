select e.name, b.bonus as bonus FROM Employee as e 
LEFT OUTER JOIN Bonus as b 
ON e.empId = b.empId
WHERE bonus < 1000 OR bonus IS null;
